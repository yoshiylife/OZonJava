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
 * $Id: ExClassPath.java,v 2.2 1997/11/07 05:10:57 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.util.Vector;
import java.util.zip.ZipFile;


/**
 * A Vector which contains CLASSPATH entries in order.
 * This class is used in class OzClassFile to search a class file of a system
 * class.
 *
 * @see Vector
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
class ExClassPath extends Vector {

    /**
     * Creates a new ExClassPath object.
     *
     * @param	classPath
     *		CLASSPATH to be represented.
     */
    ExClassPath(String classPath) {
        super(2);
        char sep = File.pathSeparatorChar;
        int i, j;

        for (i = -1, j = i + 1;
	     (i = classPath.indexOf(sep, j)) != -1; j = i + 1) {
            addEntry(classPath.substring(j, i));
        }
        addEntry(classPath.substring(j));
    }

    /**
     * A subroutine to add an entry of the CLASSPATH.
     *
     * @param	entry
     *		An entry to be added.
     */
    private final void addEntry(String entry) {
        if (entry.endsWith(File.separator)) {
            entry = entry.substring(0, entry.length() - File.separator.length());
        }
        File file = new File(entry);
        if (file.exists()) {
            if (file.isDirectory()) {
                addElement(file);
            } else {
                try {
                    addElement(ExZipFile.find(file));
                } catch (Exception e) {
                }
            }
        }
        // don't add an unreadable and/or corrupted entry
    }
}
