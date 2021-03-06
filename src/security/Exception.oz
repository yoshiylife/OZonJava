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


class AlreadyRegisteredUserException{
  new init(){}
}

class UnknownUserException{
  new init(){}
}

class SecurityException{
  new init(){}
}

class ObsoleteTicketException{
  new init(){}
}

class InvalidTicketException{
  new init(){}
}

class TimeOutException :* RuntimeException {
  new init() { super=>init(); }
}
