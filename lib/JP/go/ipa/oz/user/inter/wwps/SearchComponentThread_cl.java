package JP.go.ipa.oz.user.inter.wwps;

public class SearchComponentThread_cl extends JP.go.ipa.oz.user.inter.cgi.ExecuteThread_cl implements JP.go.ipa.oz.user.inter.wwps.SearchComponentThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.user.inter.cgi.HTMLData_if h) throws Exception  {
// 629
    super._new_create (c, h);
    return this;
  }
  
  void create_list (JP.go.ipa.oz.user.garage.SubjectGarage_if catalog, JP.go.ipa.oz.lib.standard._String_if key, JP.go.ipa.oz.lib.standard._String_if catalog_name) throws Exception  {
// 546
    JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 547
    try {
// 548
      JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator$val$191;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
        try {
          summaryIterator$val$191 = catalog.summaryIterator ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        summaryIterator$val$191 = catalog.summaryIterator ();
      }
// 548
      it = summaryIterator$val$191;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 550
      JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot found catalog: "));
      
// 550
      JP.go.ipa.oz.lib.standard._String_if concat$val$192;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$88)) {
        try {
          concat$val$192 = string$88.concat (catalog_name);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$192 = string$88.concat (catalog_name);
      }
// 550
      sendResult (concat$val$192);
// 551
      return;
    }
// 554
    JP.go.ipa.oz.lib.standard._String_if string$89 = (new JP.go.ipa.oz.lib.standard._String_cl("text/html"));
    
// 554
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.startOutput (string$89);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.startOutput (string$89);
    }
// 555
    JP.go.ipa.oz.lib.standard._String_if string$90 = (new JP.go.ipa.oz.lib.standard._String_cl("html"));
    
// 555
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$90);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$90);
    }
// 556
    JP.go.ipa.oz.lib.standard._String_if string$91 = (new JP.go.ipa.oz.lib.standard._String_cl("head"));
    
// 556
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$91);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$91);
    }
// 557
    JP.go.ipa.oz.lib.standard._String_if string$92 = (new JP.go.ipa.oz.lib.standard._String_cl("title"));
    
// 557
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$92);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$92);
    }
// 558
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (catalog_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (catalog_name);
    }
// 559
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 560
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 562
    JP.go.ipa.oz.lib.standard._String_if string$93 = (new JP.go.ipa.oz.lib.standard._String_cl("body"));
    
// 562
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$93);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$93);
    }
// 564
    JP.go.ipa.oz.lib.standard._String_if string$94 = (new JP.go.ipa.oz.lib.standard._String_cl("h1"));
    
// 564
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$94);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$94);
    }
// 565
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.addOutput (catalog_name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.addOutput (catalog_name);
    }
// 566
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 568
    JP.go.ipa.oz.lib.standard._String_if string$95 = (new JP.go.ipa.oz.lib.standard._String_cl("dl"));
    
// 568
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.beginTag (string$95);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.beginTag (string$95);
    }
// 570
    int found = 0;
// 571
    while (true) {
// 571
      boolean hasMoreElements$val$193;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          hasMoreElements$val$193 = it.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$193 = it.hasMoreElements ();
      }
      if (!(hasMoreElements$val$193)) break;
      
      /* body */ _loop_1: {
// 572
        JP.go.ipa.oz.user.ide.SubjectSummary_if summary = null;
// 573
        JP.go.ipa.oz.lang._Root_if nextElement$val$194;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$194 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$194 = it.nextElement ();
        }
// 573
        summary = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (nextElement$val$194);
        boolean bool$val$14;
        
// 575
        JP.go.ipa.oz.lib.standard._String_if getName$val$195;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getName$val$195 = summary.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$195 = summary.getName ();
        }
// 575
        int indexOf$val$196;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getName$val$195)) {
          try {
            indexOf$val$196 = getName$val$195.indexOf (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$196 = getName$val$195.indexOf (key);
        }
        bool$val$14 = indexOf$val$196 > -1;
        if (!bool$val$14) {
// 576
          JP.go.ipa.oz.lib.standard._String_if getDescription$val$197;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
            try {
              getDescription$val$197 = summary.getDescription ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getDescription$val$197 = summary.getDescription ();
          }
// 576
          int indexOf$val$198;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getDescription$val$197)) {
            try {
              indexOf$val$198 = getDescription$val$197.indexOf (key);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$198 = getDescription$val$197.indexOf (key);
          }
          bool$val$14 = indexOf$val$198 > -1;
        }
// 575
        if (bool$val$14) {{
// 577
            JP.go.ipa.oz.lib.standard._String_if getName$val$199;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
              try {
                getName$val$199 = summary.getName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getName$val$199 = summary.getName ();
            }
// 577
            JP.go.ipa.oz.lib.standard._String_if name = getName$val$199;
// 578
            if (name == null) {
// 578
              break _loop_1;
            }
// 580
            JP.go.ipa.oz.lib.standard._String_if string$96 = (new JP.go.ipa.oz.lib.standard._String_cl("dt"));
            
// 580
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addTag (string$96);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addTag (string$96);
            }
// 582
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (name);
            }
// 583
            JP.go.ipa.oz.lib.standard._String_if string$97 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
            
// 583
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (string$97);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (string$97);
            }
// 584
            JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=look&subject=")));
// 585
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$200;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$200 = buf.append (name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$200 = buf.append (name);
            }
// 586
            JP.go.ipa.oz.lib.standard._String_if string$98 = (new JP.go.ipa.oz.lib.standard._String_cl("&key="));
            
// 586
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$201;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$201 = buf.append (string$98);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$201 = buf.append (string$98);
            }
// 587
            JP.go.ipa.oz.user.garage.Key_if getKey$val$202;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
              try {
                getKey$val$202 = summary.getKey ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getKey$val$202 = summary.getKey ();
            }
// 587
            JP.go.ipa.oz.lib.standard._String_if asString$val$203;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getKey$val$202)) {
              try {
                asString$val$203 = getKey$val$202.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$203 = getKey$val$202.asString ();
            }
// 587
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$204;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$204 = buf.append (asString$val$203);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$204 = buf.append (asString$val$203);
            }
// 588
            JP.go.ipa.oz.lib.standard._String_if string$99 = (new JP.go.ipa.oz.lib.standard._String_cl("&catalog="));
            
// 588
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$205;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$205 = buf.append (string$99);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$205 = buf.append (string$99);
            }
// 589
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$206;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$206 = buf.append (catalog_name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$206 = buf.append (catalog_name);
            }
// 590
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$207;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                append$val$207 = buf.append ('\"');
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$207 = buf.append ('\"');
            }
// 591
            JP.go.ipa.oz.lib.standard._String_if asString$val$208;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                asString$val$208 = buf.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$208 = buf.asString ();
            }
// 591
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.beginTag (asString$val$208);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.beginTag (asString$val$208);
            }
// 592
            JP.go.ipa.oz.lib.standard._String_if string$100 = (new JP.go.ipa.oz.lib.standard._String_cl("Look"));
            
// 592
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (string$100);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (string$100);
            }
// 593
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.endTag ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.endTag ();
            }
// 594
            JP.go.ipa.oz.lib.standard._String_if string$101 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
            
// 594
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (string$101);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (string$101);
            }
// 595
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
              try {
                buf.setLength (0);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              buf.setLength (0);
            }
// 596
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=get&subject=")));
// 597
            buf.append (name);
// 598
            buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("&key=")));
// 599
            JP.go.ipa.oz.user.garage.Key_if getKey$val$209;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
              try {
                getKey$val$209 = summary.getKey ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getKey$val$209 = summary.getKey ();
            }
// 599
            JP.go.ipa.oz.lib.standard._String_if asString$val$210;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getKey$val$209)) {
              try {
                asString$val$210 = getKey$val$209.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$210 = getKey$val$209.asString ();
            }
// 599
            buf.append (asString$val$210);
// 600
            buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("&catalog=")));
// 601
            buf.append (catalog_name);
// 602
            buf.append ('\"');
// 603
            JP.go.ipa.oz.lib.standard._String_if asString$val$211;
            asString$val$211 = buf.asString ();
// 603
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.beginTag (asString$val$211);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.beginTag (asString$val$211);
            }
// 604
            JP.go.ipa.oz.lib.standard._String_if string$102 = (new JP.go.ipa.oz.lib.standard._String_cl("Get"));
            
// 604
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (string$102);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (string$102);
            }
// 605
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.endTag ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.endTag ();
            }
// 607
            JP.go.ipa.oz.lib.standard._String_if string$103 = (new JP.go.ipa.oz.lib.standard._String_cl("dd"));
            
// 607
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addTag (string$103);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addTag (string$103);
            }
// 608
            JP.go.ipa.oz.lib.standard._String_if getDescription$val$212;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
              try {
                getDescription$val$212 = summary.getDescription ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getDescription$val$212 = summary.getDescription ();
            }
// 608
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
              try {
                html.addOutput (getDescription$val$212);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              html.addOutput (getDescription$val$212);
            }
// 609
            found++;
          }
        }
      }
    }
// 613
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 614
    if (found == 0) {
// 615
      JP.go.ipa.oz.lib.standard._String_if string$104 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot found"));
      
// 615
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
        try {
          html.addOutput (string$104);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        html.addOutput (string$104);
      }
    }
// 616
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endTag ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endTag ();
    }
// 617
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        html.endOutput ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      html.endOutput ();
    }
// 619
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
      try {
        cgi.sendResult (html);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cgi.sendResult (html);
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 528
    JP.go.ipa.oz.lib.standard._String_if catalog_name = null;
// 529
    JP.go.ipa.oz.lib.standard._String_if string$105 = (new JP.go.ipa.oz.lib.standard._String_cl("catalog"));
    
// 529
    JP.go.ipa.oz.lang._Root_if getValue$val$213;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$213 = html.getValue (string$105);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$213 = html.getValue (string$105);
    }
// 529
    catalog_name = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$213);
// 530
    JP.go.ipa.oz.user.garage.SubjectGarage_if catalog = new JP.go.ipa.oz.user.garage.SubjectGarage_pcl (catalog_name);
// 532
    JP.go.ipa.oz.lib.standard._String_if keyword = null;
// 533
    JP.go.ipa.oz.lib.standard._String_if string$106 = (new JP.go.ipa.oz.lib.standard._String_cl("keyword"));
    
// 533
    JP.go.ipa.oz.lang._Root_if getValue$val$214;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$214 = html.getValue (string$106);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$214 = html.getValue (string$106);
    }
// 533
    keyword = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$214);
// 535
    create_list (catalog, keyword, catalog_name);
  }
  
  public SearchComponentThread_cl () throws Exception { super (); }
  
}

