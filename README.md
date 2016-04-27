## LRU-Simulation

This is a homework assignment made for CST 450 : Computer Architecture.

The array of integers simulate the behavior of an associative Cache that uses
LRU. When a new number is found and read from "SOURCE.TXT", there are 2 scenarios:
* if it is a hit, it will move everything in the array up from the original
position of the number. The found integer will then be moved to the bottom of
the array.
* if it is a miss, it will replace all the integers in the array with the one
after them causing the integer in the top of the array to be removed. It will
then add the new integer found to the bottom of the array.

I sure hope someone would find this useful in someway someday.

BinHong Lee
