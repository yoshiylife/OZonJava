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

class SchoolUtility
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// labels including in this School using dictionary
	Dictionary subjects;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SchoolUtility"
	new create(Dictionary sbj){
		subjects= sbj;
	}

	/***********
	 * METHODS *
	 ***********/
	/**backup the school to the file.
	 * @param	fileName:file name you want to backup.
	 * @exception	Exception
	 */
	public void saveToFile(String fileName, String subjectName) {
		OzLabel tmpOzLabel;
		String labelName, ifID, implID;
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(subjectName)==0){
				break;
			}
		}
		Iterator lblIterator = subject->getOzLabels()->iterator();
		try{
			StringBuffer buf=>breed();
			FileOutputStream fout=>breed(fileName);
			OutputStreamWriter osw=>breed(fout);
			BufferedWriter bw=>breed(osw);

			while( lblIterator->hasMoreElements() ) {
				tmpOzLabel =| lblIterator->nextElement();
				labelName = tmpOzLabel->getOzLabelName();
				ifID = tmpOzLabel->getInterfaceID();
				implID = tmpOzLabel->getImplementationID();
				buf->append("\"");
				buf->append(labelName);
				buf->append("\",\"");
				buf->append(ifID);
				buf->append("\",\"");
				buf->append(implID);
				buf->append("\"\n");
			}

			bw->write(buf->asString(), 0, buf->length());
			bw->close();
			fout->close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	/**load the school from the file.
	 * @param	fileName:file name you want to load.
	 * @exception	Exception
	 */
	public void loadFromFile(String fileName, String subjectName) {
		String labelName, interfaceID, implementationID, buf;
		int counter, startPoint;
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(subjectName)==0){
				break;
			}
		}

		try{
			FileInputStream fin=>breed(fileName);
			InputStreamReader isr=>breed(fin);
			BufferedReader br=>breed(isr);

			while((buf=br->readLine())!=null){
				counter = 0;
				for (int i=0; i<buf->length(); i++) {
					if (buf->charAt(i)=='"' && counter==0) {
						startPoint = i;
						counter = 1;
					}
					else if (buf->charAt(i)=='"' && counter==1) {
						labelName = buf->substring(startPoint+1, i);
						counter = 2;
					}
					else if (buf->charAt(i)=='"' && counter==2) {
						startPoint = i;
						counter = 3;
					}
					else if (buf->charAt(i)=='"' && counter==3) {
						interfaceID = buf->substring(startPoint+1, i);
						counter = 4;
					}
					else if (buf->charAt(i)=='"' && counter==4) {
						startPoint = i;
						counter = 5;
					}
					else if (buf->charAt(i)=='"' && counter==5) {
						implementationID = buf->substring(startPoint+1, i);
					}
				}
				OzLabel tmpOzLabel=>create(subjectName, labelName, makeInterfaceID(interfaceID), makeImplementationID(implementationID));
				subject->putOzLabel(tmpOzLabel);
			}
			br->close();
			isr->close();
			fin->close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public String makeInterfaceID(String interfaceID) {
		StringBuffer tmpBuf=>breed();
		if(interfaceID->startsWith("JP.go.ipa.oz.user.released."))
			interfaceID = interfaceID->substring(27);
		else if(interfaceID->startsWith("JP.go.ipa.oz.user."))
			interfaceID = interfaceID->substring(18);
		else if(interfaceID->startsWith("JP.go.ipa.oz.lib.") || interfaceID->startsWith("JP.go.ipa.oz.lang."))
			interfaceID = interfaceID->substring(12);
		else if(interfaceID->startsWith(".user.released."))
			interfaceID = interfaceID->substring(15);
		else if(interfaceID->startsWith(".user."))
			interfaceID = interfaceID->substring(6);
		if(!(interfaceID->endsWith("_if"))) {
			tmpBuf->append(interfaceID);
			tmpBuf->append("_if");
			interfaceID = tmpBuf->asString();
			tmpBuf=>breed();
		}
		return interfaceID;
	}

	public String makeImplementationID(String implementationID) {
		StringBuffer tmpBuf=>breed();
		if(implementationID->startsWith("JP.go.ipa.oz.user.released."))
			implementationID = implementationID->substring(27);
		else if(implementationID->startsWith("JP.go.ipa.oz.user."))
			implementationID = implementationID->substring(18);
		else if(implementationID->startsWith("JP.go.ipa.oz.lib.") || implementationID->startsWith("JP.go.ipa.oz.lang."))
			implementationID = implementationID->substring(12);
		else if(implementationID->startsWith(".user.released."))
			implementationID = implementationID->substring(15);
		else if(implementationID->startsWith(".user."))
			implementationID = implementationID->substring(6);
		if(!(implementationID->endsWith("_cl"))) {
			tmpBuf->append(implementationID);
			tmpBuf->append("_cl");
			implementationID = tmpBuf->asString();
			tmpBuf=>breed();
		}
		return implementationID;
	}
}
