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
 * $Id: ExCodePath.java,v 2.2 1997/11/07 05:10:57 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/**
 * A code path of a class which can be an OZ class.
 * A code path, which is also called fully qualified class name, is a
 * respresentation of a class consisted by a package name and a class name
 * concatenated with a `.'.  For example, "java.lang.Object" is a code path
 * where the package name "java.lang" and the class name "Object" is
 * concatenated with a '.'.
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
final class ExCodePath {
    /**
     * For debug & message
     */
    static final String CN = "ExCodePath";

    private static String OzTopPackage = Executor.IPAoz;
    static String OzSystemClassPackage = Executor.IPAozSystem;
    static String UserClassPackage = Executor.IPAozUser;
    static String ReleasedUserClassPackage = UserClassPackage + "released.";

    String codePath;

    /**
     * If specified codePath is of an array class,
     * basePathIndex is start index of base type name of array class.
     * Otherwise, basePathIndex is zero (also none-array).
     */
    int basePathIndex = 0;

    /**
     * If specified codePath is of an array class,
     * basePathLast is end index of base type name of array class.
     * Otherwise, basePathLast is index of last charactor with codePath.
     */
    int basePathLast;

    static
    int indexOfBasePath(String codePath)
    {
	int index = codePath.indexOf("[L");
    	return (0 <= index ? index+2 : 0);
    }

    static
    int lastOfBasePath(String codePath, int index)
    {
	int last = codePath.indexOf(';',index);
	return (0 <= last ? last : codePath.length());
    }

    ExCodePath(String codePath) {
	this.codePath = codePath;
	basePathIndex = indexOfBasePath(codePath);
	basePathLast = lastOfBasePath(codePath,basePathIndex);
    }

    /**
     * Returns the class name part of a code path: the part after the last '.'.
     */
    String getName() {
	return codePath.substring(codePath.lastIndexOf('.',basePathLast)+1,basePathLast);
    }

    /**
     * Returns the package name part of a code path: the part before the last
     * '.'.
     */
    String getParent() {
	return codePath.substring(basePathIndex, codePath.lastIndexOf('.',basePathLast));
    }

    /**
     * Returns the code path string.
     */
    String getPath() {
	return codePath;
    }

    /**
     * Returns true if the code path represents an OZ class: its package name
     * starts with "JP.go.ipa.oz". False otherwise.
     */
    boolean isOzClass() {
	return codePath.startsWith(OzTopPackage, basePathIndex);
    }

    /**
     * Returns true if the code path represents an OZ class: its package name
     * starts with "JP.go.ipa.oz". False otherwise.
     */
    static boolean isOzClass(String codePath) {
	return codePath.startsWith(OzTopPackage, indexOfBasePath(codePath));
    }

    /**
     * Returns true if the code path represents an OZ system class: its
     * package name starts with "JP.go.ipa.oz.system".  False otherwise.
     */
    boolean isOzSystemClass() {
	return codePath.startsWith(OzSystemClassPackage, basePathIndex);
    }

    /**
     * Returns true if the code path represents an OZ system class: its
     * package name starts with "JP.go.ipa.oz.system".  False otherwise. 
     *
     * @param	codePath
     *		The code path to be checked.
     */
    static boolean isOzSystemClass(String codePath) {
	return codePath.startsWith(OzSystemClassPackage,
				   indexOfBasePath(codePath));
    }

    /**
     * Returns true if the code path represents an OZ released user class: its 
     * package name starts with "JP.go.ipa.oz.user.released".  False
     * otherwise. 
     */
    boolean isReleasedUserClass() {
	return codePath.startsWith(ReleasedUserClassPackage, basePathIndex);
    }

    /**
     * Returns true if the code path represents an OZ released user class: its
     * package name starts with "JP.go.ipa.oz.user.released".  False
     * otherwise. 
     *
     * @param	codePath
     *		The code path to be checked.
     */
    static boolean isReleasedUserClass(String codePath) {
	return codePath.startsWith(ReleasedUserClassPackage,
				   indexOfBasePath(codePath));
    }

    /**
     * Returns true if the code path represents an OZ user class: its package
     * name starts with "JP.go.ipa.oz.user".  False otherwise. 
     */
    boolean isUserClass() {
	return codePath.startsWith(UserClassPackage,basePathIndex);
    }

    /**
     * Returns true if the code path represents an OZ user class: its package
     * name starts with "JP.go.ipa.oz.user".  False otherwise. 
     *
     * @param	codePath
     *		The code path to be checked.
     */
    static boolean isUserClass(String codePath) {
	return codePath.startsWith(UserClassPackage,indexOfBasePath(codePath));
    }

    /**
     * @return true if it is array class that represented by code path.
     */
    boolean isArrayClass()
    {
    	return (basePathIndex != 0);
    }
    
    /**
     * @return the dimension of array class represented by code path.
     */
    int getDimension()
    {
    	return (basePathIndex - 1);
    }

    /**
     * @return the code path which base type of array class represented by code path.
     */
    String getBasePath()
    {
	return codePath.substring(basePathIndex, basePathLast);
    }
    
    /**
     * Returns a string representation of the code path: the code path string.
     */
    public String toString() {
	return codePath;
    }
}
