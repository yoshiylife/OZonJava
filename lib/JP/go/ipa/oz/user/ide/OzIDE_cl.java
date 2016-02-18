package JP.go.ipa.oz.user.ide;

public class OzIDE_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.ide.OzIDE_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.ide.ProjectManager_if projectMng;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  
  protected void initialize () throws Exception  {
// 21
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if pmQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 22
    projectMng = (JP.go.ipa.oz.user.ide.ProjectManager_cl) (new JP.go.ipa.oz.user.ide.ProjectManager_cl ())._new_create (pmQueue);
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.setVisible (true);
    }
// 25
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if sbQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 26
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_cl) (new JP.go.ipa.oz.user.ide.SchoolBrowser_cl ())._new_create (sbQueue);
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.setVisible (true);
    }
// 28
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.setSchoolBrowser (schoolBrowser);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.setSchoolBrowser (schoolBrowser);
    }
  }
  
  protected void quiet () throws Exception  {
// 44
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.deleteListeners ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.deleteListeners ();
    }
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.deleteListeners ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.deleteListeners ();
    }
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.setVisible (false);
    }
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.setVisible (false);
    }
// 48
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 33
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if pmQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 34
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.activateListeners (pmQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.activateListeners (pmQueue);
    }
// 35
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectMng)) {
      try {
        projectMng.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectMng.setVisible (true);
    }
// 37
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if sbQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 38
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.activateListeners (sbQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.activateListeners (sbQueue);
    }
// 39
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.setVisible (true);
    }
  }
  
  public OzIDE_cl () { super ("JP.go.ipa.oz.user.ide.OzIDE_pcl"); }
  
  public OzIDE_cl (String proxy_id) { super (proxy_id); }
  
}

