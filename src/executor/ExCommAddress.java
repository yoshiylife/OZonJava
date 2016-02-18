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

import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
//import java.io.MethodMissingException;
//import java.io.ClassMismatchException;
/***
 * A class representing a physical location of object and/or executor.
 * @version    0.01(First implementation)
 * @author     Yoichi Hamazaki
 * @author     Yasumitsu Yoshida(reviser)
 */
class ExCommAddress
implements OzCommAddress, Serializable{
  /**
   * Internet Address (IP-address) of executor.<br>
   * Location of executor is determined by address and port.<br>
   * If address is null, that ExCommAddress has no data.
   */
  InetAddress address;

  /**
   * Port number of executor
   */
  int         port;

  /**
   * Cell's index within an executor.<br>
   * cellNumber may not be used when ExCommAddress is used
   * as executor's location rather than object's location.
   */
  int         cellNumber;

  private static String CN="ExCommAddress";

   /***
   * construct with parameters
   * @param a       InetAddress
   * @param p       port number
   * @param cellnum cell number
   */
  ExCommAddress(InetAddress a,int p,int cellnum){
    address=a;
    port=p;
    cellNumber=cellnum;
  }

   /***
   * construct without parameters.<br>
   * Initial values are, null InetAddress, port number=0,cell number=0.
   */
  ExCommAddress(){
    address= null;
    port=0;
    cellNumber=0;
  }

   /***
   * construct from InputStream.
   * @param istream InputStream which expected to be made by #writeToStream.
   * @see #writeToStream.
   */
  ExCommAddress(InputStream istream)
    throws Exception
    {
      ObjectInputStream ois = new ExObjectInputStream(istream);
      address = (InetAddress)ois.readObject();
      port = ois.readInt();
      cellNumber = ois.readInt();
    }

  /**
   * Compare as executor's locations.<br>
   *
   * @param o ExCommAddress object to be compared.
   * @return  return true if IP-address and port number are identical.
   */
  public boolean equals(Object o){
    ExCommAddress other = (ExCommAddress)o;
    return ((port == other.port) && address.equals(other.address));
  }

  /**
   * Compare as cell's locations.<br>
   *
   * @param o ExCommAddress object to be compared.
   * @return  return true if IP-address,port number and cellNumber 
   * are identical.
   */
  public boolean cellEquals(ExCommAddress other){
    return ((cellNumber == other.cellNumber) && equals(other));
  }

  /***
   * hash function
   */
  public int hashCode(){
    return address.hashCode() + port;
  }

  /***
   * conver to String form.
   */
  public String toString(){
    return address.toString() + ":" +port+"Cell_No:"+cellNumber;
  }

  /***
   * write to OutputStream which will be used as input of constructor.
   * @param ostream OutputStream
   */
  void writeToStream(OutputStream ostream) throws IOException
    {
      ObjectOutputStream oos = new ExObjectOutputStream(ostream);
      oos.writeObject(address);
      oos.writeInt(port);
      oos.writeInt(cellNumber);
    }

    /**
     * Returns the IP address string.
     */
    public
    String getHostAddress()
    {
	return address.getHostAddress();
    }

    /**
     * Returns the port number.
     */
    public
    int getPort()
    {
	return port;
    }
}
