#pragma once
#ifdef __cplusplus
extern "C" {
#endif

int primes_count(long first, long last);
long primes_fetch(long start, int count, long* collect);

#ifdef __cplusplus
}
#endif

