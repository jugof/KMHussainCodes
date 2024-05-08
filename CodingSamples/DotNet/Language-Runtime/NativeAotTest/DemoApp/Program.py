from ctypes import *

bizcalc = CDLL('bin/Release/net8.0/linux-x64/publish/BizCalc.so')
bizcalc.asset_future_price.argtypes = [c_double, c_int, c_int, c_bool]
bizcalc.asset_future_price.restype = c_double

c = float(input('Original Cost: '))
n = int(input('Useful Life  : '))
s = input('Use SYD (y/N): ') == 'y'

for a in range(1, n):
    p = bizcalc.asset_future_price(c, n, a, s)
    print('%-6d%16.2f' % (a, p))


