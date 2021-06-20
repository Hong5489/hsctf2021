# sneks

## Description
```
https://www.youtube.com/watch?v=0arsPXEaIUY
```
## Files
- [output.txt](output.txt)
- [sneks.pyc](sneks.pyc)

Looks like we have a Python Compiled file (.pyc) 

Lets use `uncompyle6` to decompile the file! (Can install it with `pip install uncompyle6`)

```py
# uncompyle6 version 3.7.4
# Python bytecode 3.8 (3413)
# Decompiled from: Python 3.8.5 (default, Aug  2 2020, 15:09:07) 
# [GCC 10.2.0]
# Embedded file name: sneks.py
# Compiled at: 2021-05-20 03:21:59
# Size of source mod 2**32: 600 bytes
import sys

def f(n):
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    x = f(n >> 1)
    y = f(n // 2 + 1)
    return g(x, y, not n & 1)


def e(b, j):
    return 5 * f(b) - 7 ** j


def d(v):
    return v << 1


def g(x, y, l):
    if l:
        return h(x, y)
    return x ** 2 + y ** 2


def h(x, y):
    return x * j(x, y)


def j(x, y):
    return 2 * y - x


def main():
    if len(sys.argv) != 2:
        print('Error!')
        sys.exit(1)
    inp = bytes(sys.argv[1], 'utf-8')
    a = []
    for i, c in enumerate(inp):
        a.append(e(c, i))
    else:
        for c in a:
            print((d(c)), end=' ')


if __name__ == '__main__':
    main()
# okay decompiling sneks.pyc
```

You can see the flow from the source code:

1. it takes the first argument as `inp`
2. loop each character pass into function `e` 
3. append the output into `a`
4. loop each number in `a` pass into function `d`
5. print the output separate by space

## Solve
The functions are quite complicated its hard to reverse it especially function `f`

So I decide to **brute force the flag** since it pass in the function **character by character** makes the brute force time fast

```py
output = [9273726921930789991758, 166410277506205636620946, 836211434898484229672, 15005205362068960832084, 226983740520068639569752018, 4831629526120101632815236, 203649875442, 1845518257930330962016244, 12649370320429973923353618, 203569403526, 435667762588547882430552, 2189229958341597036774, 175967536338, 339384890916, 319404344993454853352, -9165610218896, 435667762522082586241848, 3542248016531591176336 ,319401089522705178152 ,-22797257207834556 ,12649370160845441339659218 ,269256367990614644192076 ,-7819641564003064368 ,594251092837631751966918564 ]

for i, n in enumerate(output):
	for c in string.printable.encode():
		if d(e(c,i)) == n:
			print(chr(c),end='')
			break

# flag{s3qu3nc35_4nd_5um5}
```
Thats it! Simple reverse challenge!

[Full python script](solve.py)

## Flag
```
flag{s3qu3nc35_4nd_5um5}
```