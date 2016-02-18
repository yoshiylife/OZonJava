
REM compile DistributedTransactionLib.

echo "compiling *.oz"
call ozc -i -s tran_all.s Debug.oz
call ozc -i -s tran_all.s TID.oz
call ozc -i -s tran_all.s Exception.oz
call ozc -i -s tran_all.s Status.oz
call ozc -i -s tran_all.s Resource.oz
call ozc -i -s tran_all.s TransactionResource.oz
call ozc -i -s tran_all.s TransactionTimer.oz
call ozc -i -s tran_all.s Transaction.oz
echo "interface compiled"

call ozc -s tran_all.s Debug.oz
call ozc -s tran_all.s TID.oz
call ozc -s tran_all.s Exception.oz
call ozc -s tran_all.s Status.oz
call ozc -s tran_all.s Resource.oz
call ozc -s tran_all.s TransactionResource.oz
call ozc -s tran_all.s TransactionTimer.oz
call ozc -s tran_all.s Transaction.oz
echo "compiled all"

