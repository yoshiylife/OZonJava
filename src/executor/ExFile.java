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
 * $Id: ExFile.java,v 1.1 1997/11/07 05:04:10 yoshi Exp $
 */
package JP.go.ipa.oz.system;

import java.io.*;

/**
 * A file, which can contain the content of a class file.
 * Although the JDK has the class java.io.File, the OZ system needs a
 * file class which implements a same interface with a zip file entry class.
 *
 * @see ExFileContentHolder
 * @see OzClassFile
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:04:10 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
final class ExFile extends File implements ExFileContentHolder {

    /**
     * Creates an ExFile object.
     *
     * @param	path
     *		The file path.
     */
    public ExFile(String path) {
	super(path);
    }

    /**
     * Returns an OutputStream of this file.
     * Invoking this method on a not-existed file will create a file.
     *
     * @see java.io.OutputStream
     * @exception	java.io.IOException
     *		This file is not modifiable.
     */
    public OutputStream getOutputStream() throws IOException  {
	String parent = getParent();
	if (parent != null) {
		File file = new File(parent);
		if (! file.exists()) file.mkdirs();
	}
	return new FileOutputStream(this);
    }

    /**
     * Returns an InputStream of this class file.
     *
     * @see java.io.InputStream
     * @exception	java.io.IOException
     *		This file cannot be read.
     */
    public InputStream getInputStream() throws IOException {
	return new FileInputStream(this);
    }
}
