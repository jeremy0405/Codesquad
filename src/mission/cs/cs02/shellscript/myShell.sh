#!/bin/bash

if ! [ -d backup ]; then
	mkdir backup
fi

for i in `seq 1 1 16`
do
	cd day$i

	if [ -f *.cs ]; then
		cp *.cs ../backup
	else
		echo "day$i에는 cs 파일이 존재하지 않습니다."
	fi

	cd ..
done

today=$(date "+%Y%m%d")

zip $today.zip backup/*

scp $today.zip jerry@192.168.19.128:~/backup/$today.zip

