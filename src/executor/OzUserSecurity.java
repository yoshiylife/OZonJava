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

/*
 * $Id: OzUserSecurity.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/**
 * The user security control object
 */

public class OzUserSecurity {
    /**
     * Confirms accepting a socket.
     *
     * @param	host
     *		The host name of the socket
     * @param	port
     *		The port number of the socket
     */
    public void confirmAccept(String host, int port) {
    }

    /**
     * Confirms connecting a socket.
     *
     * @param	host
     *		The host name of the socket
     * @param	port
     *		The port number of the socket
     */
    public void confirmConnect(String host, int port) {
    }

    /**
     * Confirms a file deletion.
     *
     * @param	fileName
     *		The name of file to be deleted.
     */
    public void confirmDelete(String fileName) {
    }

    /**
     * Confirms a external command execution.
     */
    public void confirmExec(String cmd) {
    }

    /**
     * Confirms listening a socket.
     */
    public void confirmListen(int port) {
    }

    /**
     * Confirms accessing an entire system property list.
     */
    public void confirmPropertiesAccess() {
    }

    /**
     * Confirms accessing a system property.
     */
    public void confirmPropertyAccess(String key) {
    }

    /**
     * Confirms reading a file.
     */
    public void confirmRead(String fileName) {
    }

    /**
     * Confirms writing a file.
     */
    public void confirmWrite(String fileName) {
    }

    /**
     * Confirms creating a new global object.
     */
    public void confirmNewGlobalObject(OzProxy proxy) {
    }

    /**
     * Confirms starting a global object.
     */
    public void confirmGoGlobalObject(OzProxy proxy) {
    }

    /**
     * Confirms to stop a global object.
     */
    public void confirmStopGlobalObject(OzProxy proxy) {
    }

    /**
     * Confirms removal of a global object.
     */
    public void confirmRemoveGlobalObject(OzProxy proxy) {
    }

    /**
     * Confirms accessing to command line argument count.
     */
    public void confirmGetArguments() {
    }

    /**
     * Confirms accessing to the standard input stream.
     */
    public void confirmGetStdin() {
    }

    /**
     * Confirms accessing to the standard output stream.
     */
    public void confirmGetStdout() {
    }

    /**
     * Confirms accessing to the standard error stream.
     */
    public void confirmGetStderr() {
    }

    /**
     * Confirms reading a class file.
     */
    public void confirmCheckClassFileRead(String codePath) {
    }

    /**
     * Confirms writing a class file.
     */
    public void confirmCheckClassFileWrite(String codePath) {
    }
}
