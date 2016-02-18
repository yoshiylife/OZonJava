/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

package JP.go.ipa.oz.system;

/***
* identifier of session. ExSessionId shuld be unique world-wide.
*/
class ExSessionId{
  static private String CN="ExSessionId";
  byte id[];
  boolean ipV6;
  static private String[] hex = {"0","1","2","3","4","5","6","7",
				   "8","9","a","b","c","d","e","f"};
  /* seeds */
  static int uniqueNumber;
  static byte ipAddress[];
  static int portNumber;

  /***
   * initialize.
   */
  synchronized static void initialize(byte ip[],int port)
    {
      ipAddress=ip;
      portNumber=port;
      uniqueNumber=0;
    }

  /***
   * get String value
   */
  synchronized static String statusString()
    {
      int i;
      String str;
      for(i=1,str=""+ipAddress[0];i<ipAddress.length;i++)
	{
	  str = str+"."+ipAddress[i];
	}
      str = str+":"+portNumber+" NextUnique="+uniqueNumber;
      return str;
    }

  /***
   * set seed values
   */
  private void setId(byte ip[],int port,int unique){
      int i;
      id=new byte[ip.length+4];
      for(i=0;i<ip.length;i++)
	id[i]=ip[i];
      id[i]= (byte)((port&0xff00)>>8);
      id[i+1]=(byte)((port&0xff));
      id[i+2]=(byte)((unique&0xff00)>>8);
      id[i+3]=(byte)((unique&0xff));
      ipV6 = (ip.length!=4);
  }

  /***
   * construct ExSessionId with specific seed value
   */
  ExSessionId(byte ip[],int port,int unique)
    {
      setId(ip,port,unique);
    }
  
  /***
    * construct ExSessionId with seed value.
    */
  ExSessionId()
    {
      uniqueNumber = (uniqueNumber+1)&0xffff;
      setId(ipAddress,portNumber,uniqueNumber);
    }

  /**
   *@param dummy is added to distinguish this from constructor which takes
   ip+port+uniquenumber as arguments.
   */
  ExSessionId(byte buf[],int offset, int count,int dummy)
    {
      int i;
      id = new byte[count];
      for(i=0;i<count;i++,offset++)
	{
	  id[i]=buf[offset];
	}
      ipV6=(count!=8);
    }

  /***
   * hash function.
   */
  public int hashCode()
    {
      int h=0;
      for(int i=0; i<id.length ; i++)
	h += (int)(id[i]);

      return h;
    }

  /***
    * equality of ExSessionId.
    */
  public boolean equals(Object o)
    {    
      int i;
      byte otherId[] = ((ExSessionId)o).id;

      if((i=id.length) != otherId.length)
	{
//Executor.message(CN+"#equals returns fals because of length");
	  return false;
	}
      else{
	for(;i>0;i--)
	  if(id[i-1] != otherId[i-1])
	    {
//Executor.message(CN+"#equals returns fals because of "+(i-1)+
// " th byte"+id[i-1] + " vs "+otherId[i-1]);
	      return false;
	    }
	return true;
      }
    }

  /***
   * make String representation of ExSessionId.
   */
  public String toString(){
    int i1,i2,i;
    String hexString;
    for(i=0,hexString="";i<id.length;i++)
      {
	i1= (((int)id[i])&0xf0)>>4;
	i2= ((int)id[i]&0xf);
	hexString = hexString+hex[i1]+hex[i2];
      }
    return hexString;
  }

  /***
   * get id, the current seed value.
   */
  public byte[] getId(){
    return id;
  }

}
