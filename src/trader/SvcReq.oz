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

class ServiceRequest{
 protected String serviceName;
 new create(){}
 public final void   setServiceName(String s){serviceName=s;}
 public final String getServiceName(){return serviceName;}
 public int preference(Broker br){return 0;}//must be over wriden
}

