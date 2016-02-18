#!/bin/sh
#
# インターワーキング用 CoTraderの設定

case $# in
0) echo " Usage: addCoTrader.sh GOL_of_CoTrader";exit;
esac

oz -f addCoTrader.e $1

