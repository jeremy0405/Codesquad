#!/bin/bash

if ! [ -d backup ]; then
	mkdir backup
fi

echo ==============백업중===============

for i in `seq 1 1 16`
do
	cd day$i

	csFiles=(`find . -name "*.cs"`)

	if [ -n "${csFiles[0]}" ]; then
		mkdir ../backup/day$i
		cp *.cs ../backup/day$i
	else
		echo day$i"에는 cs파일이 존재하지 않습니다."
	fi

	cd ..

done

today=$(date "+%Y%m%d")

zip $today.zip backup/* > /dev/null

scp $today.zip jerry@192.168.0.15:~/backup/$today.zip

rm -rf backup

rm $today.zip

echo =============백업완료===============
