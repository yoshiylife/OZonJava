package JP.go.ipa.oz.user.ide;

public class Project_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.Project_if {
  JP.go.ipa.oz.lib.standard._String_if projectName;
  JP.go.ipa.oz.lib.standard._String_if projectDir;
  JP.go.ipa.oz.lib.standard._Array_if files;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if prjName) throws Exception  {
// 52
    projectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (prjName);
// 53
    files = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 54
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        putAt$val$0 = files.putAt (0, prjName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$0 = files.putAt (0, prjName);
    }
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 45
    projectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 46
    files = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 47
    projectDir = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
    return this;
  }
  
  public void addFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
    checkSecureInvocation ();
// 118
    int sizeOfFiles = 0;
// 119
    int size$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        size$val$1 = files.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$1 = files.size ();
    }
// 119
    sizeOfFiles = size$val$1;
// 120
    JP.go.ipa.oz.lib.standard._Array_if resize$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        resize$val$2 = files.resize (sizeOfFiles + 1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      resize$val$2 = files.resize (sizeOfFiles + 1);
    }
// 121
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        putAt$val$3 = files.putAt (sizeOfFiles, fileName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$3 = files.putAt (sizeOfFiles, fileName);
    }
  }
  
  public void setProjectDir (JP.go.ipa.oz.lib.standard._String_if prjDir) throws Exception  {
    checkSecureInvocation ();
// 92
    projectDir = prjDir;
  }
  
  public void setFiles (JP.go.ipa.oz.lib.standard._Array_if f) throws Exception  {
    checkSecureInvocation ();
// 109
    files = f;
  }
  
  public void setProjectName (JP.go.ipa.oz.lib.standard._String_if prjName) throws Exception  {
    checkSecureInvocation ();
// 75
    projectName = prjName;
  }
  
  public void removeAllFiles () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 149
      JP.go.ipa.oz.lib.standard._Array_if resize$val$4;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
        try {
          resize$val$4 = files.resize (1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        resize$val$4 = files.resize (1);
      }
    } finally {
      leave ();
    }
  }
  
  public void removeFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 130
      int sizeOfFiles = 0;
// 131
      int count = 0;
// 132
      int i = 0;
// 133
      int size$val$5;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
        try {
          size$val$5 = files.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$5 = files.size ();
      }
// 133
      sizeOfFiles = size$val$5;
// 134
      JP.go.ipa.oz.lib.standard._String_if fName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 136
      /* for loop starting here */ {
        /* initialization part */
// 136
        count = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(count < sizeOfFiles)) break;
          
          /* body */ _loop_1: {
// 137
            JP.go.ipa.oz.lang._Root_if at$val$6;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
              try {
                at$val$6 = files.at (count);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$6 = files.at (count);
            }
// 137
            fName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$6);
// 138
            int compareTo$val$7;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
              try {
                compareTo$val$7 = fName.compareTo (fileName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              compareTo$val$7 = fName.compareTo (fileName);
            }
// 138
            if (compareTo$val$7 == 0) {
// 138
              break;
            }
          }
          /* iteration part */
// 136
          count++;
        }
      }
// 141
      /* for loop starting here */ {
        /* initialization part */
// 141
        i = count;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < sizeOfFiles - 1)) break;
          
          /* body */ _loop_1: {
// 142
            JP.go.ipa.oz.lang._Root_if at$val$8;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
              try {
                at$val$8 = files.at (i + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$8 = files.at (i + 1);
            }
// 142
            fName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$8);
// 143
            JP.go.ipa.oz.lib.standard._Array_if putAt$val$9;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
              try {
                putAt$val$9 = files.putAt (i, fName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              putAt$val$9 = files.putAt (i, fName);
            }
          }
          /* iteration part */
// 141
          i++;
        }
      }
// 145
      JP.go.ipa.oz.lib.standard._Array_if resize$val$10;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
        try {
          resize$val$10 = files.resize (sizeOfFiles - 1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        resize$val$10 = files.resize (sizeOfFiles - 1);
      }
    } finally {
      leave ();
    }
  }
  
  public int getNumOfFiles () throws Exception  {
    checkSecureInvocation ();
// 158
    int size$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        size$val$11 = files.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$11 = files.size ();
    }
// 158
    return size$val$11;
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getFiles () throws Exception  {
    checkSecureInvocation ();
// 100
    return files;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception  {
    checkSecureInvocation ();
// 66
    return projectName;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception  {
    checkSecureInvocation ();
// 83
    return projectDir;
  }
  
  public Project_cl () throws Exception { super (); }
  
}

