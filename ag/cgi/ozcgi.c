#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <errno.h>

#define BUFFER_SIZE 2048
#define TRUE 1
#define FALSE 0

main(int argc, char **argv)
{
  int c;
  FILE *fd;
  int length,l;
  char *content_length;
  char buf[BUFFER_SIZE],*bp;
  char *ag_host_name;
  struct sockaddr_in ag_address;
  struct hostent *ag_ent;
  int s;
  int i,ii,iii;
  unsigned int ui;
  int flag;

  char *ipString;
  int portNumber;

  flag=FALSE;

  /*
   * ozcgi take two command line arguments.
   * First argument represents host name of Oz application gateway.
   * Second argument represents port number of Oz application gateway.
   */

  if(argc !=3)
    {
      printf("HTTP/1.0 500 OZ ApplicationGateway CGI internal error(argc)\r\n");
      printf("\r\n");
      return;
    }

  ipString=argv[1];
  portNumber=atoi(argv[2]);

  if((s=socket(PF_INET,SOCK_STREAM,0))<0)
    { /* socket creation failure */
      printf("HTTP/1.0 500 OZ ApplicationGateway CGI internal error(socket)\r\n");
      printf("\r\n");
      return;
    }

  if((ag_ent = gethostbyname(ipString))==NULL)
    { /* host entry aquire failure */
      printf("HTTP/1.0 500 OZ ApplicationGateway CGI internal error(host %s port %d)\r\n",ipString,portNumber);
      printf("\r\n");
      return;
    }


  ag_address.sin_addr.s_addr= *((int *)(ag_ent->h_addr_list[0]));
  ag_address.sin_port = portNumber; 
  ag_address.sin_family=AF_INET;

  if(connect(s,(struct sockaddr*)(&ag_address),sizeof(struct sockaddr_in))<0)
    {
      printf("HTTP/1.0 404 OZ ApplicationGateway Not Available\r\n");
      printf("\r\n");
      return;
    }

  /*
    fd = fopen("OzAgLog","w");
    */

  content_length=getenv("CONTENT_LENGTH");
  sscanf(content_length,"%d",&length);
  l=length;

  /*
    fprintf(fd,"OzMessage: content_length is %d\r\n",length);
    */

  for(;length>0;)
    {
      if((i=read(0,buf,BUFFER_SIZE))<=0)
	{ /* read error from stdin(data from httpd) */
	  printf("HTTP/1.0 400 OZ Bad request (insufficient contents length %d read %d left %d)\r\n",l,i,length);
	  printf("\r\n");
	  close(s);
	  return;	 
	}
      length-=i;
      /*
	fprintf(fd,"OzMessage: read %d bytes, remains %d bytes\r\n",i,length);
	*/
      for(bp=buf;i>0;)
	{
	  if((ii=write(s,bp,i))<0)
	    { /* write error to ApplicationGateway */
	      printf("HTTP/1.0 400 OZ Bad request (ApplicationGW failure to write)\r\n");
	      printf("\r\n");
	      close(s);
	      return;
	    }
	  i-=ii;
	  bp+=ii;
	}
    }
  /*
    fprintf(fd,"OzMessage: now wait for response \r\n");
    */

  do{
    /* clear buffer to null characters */
    for(i=0;i<BUFFER_SIZE;i++)
      buf[i]='\0';
    if((i=read(s,buf,BUFFER_SIZE))<0)
      {
	if(!flag)
	  { /* read error from ApplicationGateway */
	    printf("HTTP/1.0 400 OZ Bad request (ApplicationGW failure to read(errno=%d)\r\n",errno);
	    printf("\r\n");
	    close(s);
	    return;	 
	  }
	else
	  break;
      }
    printf("%s",buf);
    flag=TRUE;
  }while(i!=0);
  
  /*
    fflush(fd);
    fclose(fd);
    */
  close(s);
  return;
}

