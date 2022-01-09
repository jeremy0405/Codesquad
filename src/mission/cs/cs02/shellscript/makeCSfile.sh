#!/bin/bash

mkdir day{1..16}

for i in `seq 1 1 16`
do
	random_num="$(($RANDOM% 16))"
	random_num=$(($random_num+1))
	echo $random_num
	random_file_name="$(($RANDOM% 10))"
	random_file_name=$(($random_file_name+1))
	touch day$random_num/$random_file_name.cs
done

