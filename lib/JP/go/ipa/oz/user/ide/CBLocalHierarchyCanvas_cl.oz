// DEV: Class Browser


/**
 * CBlocalHierarchyCanvas
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */


final class CBLocalHierarchyCanvas
 : *Canvas
{

  CBIGraph  graph;
  Array  levelList;  // Array<SList>
  Array  levelWidthList;  // Array<Integer>
  PaintDispatchingQueue  pq;
  Color  classBoxColor, classLabelColor;
  Insets  areaInsets, boxInsets;
  int  vSpace;  // vertical space between class boxes
  int  hSpace;  // horizontal space between class boxes
  int  fontHeight;
  boolean  notPositioned;

  System  system;
  

  //------------------------------------------------------------------
  new newCBLocalHierarchyCanvas(CBIGraph g)
  {
    pq => create();
    super => newCanvas(pq);

    system => create();
    system->debugPrintln("\tCBLocalHierarchyCanvas#new");

    initParams(g);
    initGUI();
  }


  /////////////////////////////////////////////////////// public methods


  //------------------------------------------------------------------
  public void paint(Graphics g)
  {
    if (notPositioned) {
      FontMetrics  fm;
      fm = g->getFontMetrics();
      mkPositions(fm);
    }
    //g->drawString("not implemented yet...", 10, 10);
    drawHierarchy(g);
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void drawHierarchy(Graphics g)
  {
    Iterator  itr, itrSub;
    CBIGraphNode  node, subNode;
    int  lineHStep, lineVStep;
    int  x, y, w, h;
    int  subX, subY;
    int  boxLeftInsets, boxBottomInsets;

    boxLeftInsets = boxInsets->getLeft();
    boxBottomInsets = boxInsets->getBottom();
    lineVStep = (fontHeight + boxBottomInsets + boxInsets->getTop()) / 2;
    lineHStep = 5;
    itr = graph->nodes();
    while (itr->hasMoreElements()) {
      node =| itr->nextElement();
      x = node->getX();
      y = node->getY();
      w = node->getWidth();
      h = node->getHeight();
      /*
      g->setColor(classBoxColor);
      g->draw3DRect(x, y, w, h, true);
      g->setColor(classLabelColor);
      */
      g->drawRect(x, y, w, h);
      g->drawString(node->getLabelName(),
                    x + boxLeftInsets, y + h - boxBottomInsets);
      itrSub = node->subNodes();
      while (itrSub->hasMoreElements()) {
        subNode =| itrSub->nextElement();
        subX = subNode->getX();
        subY = subNode->getY();
        g->drawLine(x + w + lineHStep, y + lineVStep,
                    subX - lineHStep, subY + lineVStep);
      }
    }

  }


  //--------------------------------------------------------------------
  void initGUI()
  {
    Color  bgColor;

    system->debugPrintln("\tCBLocalHierarchyCanvas#initGUI");
    bgColor => newColorAsWhite();
    setBackground(bgColor);

    classBoxColor => newColorAsYellow();
    classLabelColor => newColorAsBlack();
  }


  //--------------------------------------------------------------------
  void initParams(CBIGraph g)
  {
    system->debugPrintln("\tCBLocalHierarchyCanvas#initParams");
    graph = g;
    areaInsets => newInsets(10, 10, 10, 10);
    boxInsets => newInsets(2, 4, 4, 4);
    vSpace = 20;
    hSpace = 50;
    notPositioned = true;
  }



  //--------------------------------------------------------------------
  /* SList version --- each level list is implemented as an SList.
   */
  void mkLevels(FontMetrics fm)
  {
    SList  list, nextList, oldList;
    CBIGraphNode  node, superNode;
    Iterator  itr, itrSuper;
    int  level;
    int  maxWidth, width, hBoxInsets;
    Integer  maxWidthObj;

    system->debugPrintln("\tCBLocalHierarchyCanvas#mkLevels");

    hBoxInsets = boxInsets->getLeft() + boxInsets->getRight();

    graph->clearMarks();
    levelList => create(1);
    levelWidthList => create(1);
    node = graph->getPrimaryNode();
    node->setMark(true);
    node->setLevel(0);
    list => create();
    list->pushBack(node);
    maxWidth = fm->stringWidth(node->getLabelName()) + hBoxInsets;

    for (level = 0; !(list->isEmpty()); level++) {
      if ((levelList->size()) <= level) {
        levelList->resize(level + 1);
        levelWidthList->resize(level + 1);
      }
      levelList->putAt(level, list);
      maxWidthObj => breed(maxWidth);
      levelWidthList->putAt(level, maxWidthObj);
      nextList => create();
      maxWidth = 0;
      itr = list->iterator();
      while (itr->hasMoreElements()) {
        node =| itr->nextElement();
        itrSuper = node->superNodes();
        while (itrSuper->hasMoreElements()) {
          superNode =| itrSuper->nextElement();
          if (superNode->isMarked()) {
            oldList =| levelList->at(superNode->getLevel());
            oldList->remove(superNode);
          }
          superNode->setMark(true);
          superNode->setLevel(level + 1);
          nextList->pushBack(superNode);
          width = fm->stringWidth(superNode->getLabelName()) + hBoxInsets;
          if (maxWidth < width) {
            maxWidth = width;
          }
        }
      }
      list = nextList;
    }
  }


  //--------------------------------------------------------------------
  void mkPositions(FontMetrics fm)
  {
    Collection  list;
    CBIGraphNode  node;
    Iterator  itr;
    int  boxLeft, boxTop, boxWidth, boxHeight, yMax, vStep;
    int  nNodes, nLevels, level;
    int  index;
    Integer  maxWidthObj;

    system->debugPrintln("\tCBLocalHierarchyCanvas#mkPositions");

    mkLevels(fm);

    fontHeight = fm->getHeight();

    boxLeft = areaInsets->getLeft();
    boxHeight = fontHeight + boxInsets->getTop() + boxInsets->getBottom();
    vStep = boxHeight + vSpace;
    nLevels = levelList->size();
    for (level = nLevels - 1; level >= 0; level--) {
      list =| levelList->at(level);
      itr = list->iterator();
      maxWidthObj =| levelWidthList->at(level);
      boxWidth = maxWidthObj->intValue();
      boxTop = areaInsets->getTop();
      yMax = 0;
      while (itr->hasMoreElements()) {
        node =| itr->nextElement();
        node->setBounds(boxLeft, boxTop, boxWidth, boxHeight);
        boxTop += vStep;
      }

      if (yMax < (boxTop + boxHeight)) {
        yMax = boxTop + boxHeight;
      }
      if (!(list->isEmpty())) {
        boxLeft += (boxWidth + hSpace);
      }
    }

    setSize(boxLeft + (areaInsets->getRight()),
            yMax + (areaInsets->getBottom()));

    notPositioned = false;
  }

}

// EoF

