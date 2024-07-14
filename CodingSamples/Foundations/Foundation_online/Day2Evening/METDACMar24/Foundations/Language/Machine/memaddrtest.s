	.include "common.i"

	.entry run
run:
done:	ret

#procedure to compute sum of all integers upto the value 
#in rax register
Compute:		
	mov	rcx, rax
	add	rax, 1
	mul	rcx
	shr	rax, 1 	#fast way to divide rax by 2
	ret		#return control to instruction after call

askm:	.string	"Month[1-12]: "
tell:	.string	"Total Amount = "
year:	.quad	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	.end

