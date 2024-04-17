	.include "common.i"

	.entry run
run:
	GetInt	askl
	mov	rsi, rax	#rsi=M
	GetInt	asku		
	mov	rdi, rax	#rdi=N

	cmp	rsi, rdi
	jg	done		#branching

	mov	rax, rsi	#rax=M
	sub	rax, 1		#rax=M-1
	call	Compute		#send execution control to Compute procedure
	mov	rbx, rax	#rbx=1+2+3+...+(M-1)

	mov	rax, rdi	#rax=N
	call	Compute		#rax=1+2+3+...+N
	sub	rax, rbx	

	PutInt	tell
done:	ret

#procedure to compute sum of all integers upto the value 
#in rax register
Compute:		
	mov	rcx, rax
	add	rax, 1
	mul	rcx
	shr	rax, 1 	#fast way to divide rax by 2
	ret		#return control to instruction after call

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Integers: "

	.end

