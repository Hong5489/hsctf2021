from Crypto.Util.number import *
import binascii
p = getPrime(1024)
q = getPrime(1024)
n = p*q
e = 2**16+1

p_high = p>>512
q_low = q%(2**512)
q_high = n//(p_high<<512) >> 512
q = q_high << 512 | q_low
print(n%q==0)

p_low = n * inverse(q_low,2**512) % 2**512 
p = p_high << 512 | p_low
q = n // p
print(n==p*q)