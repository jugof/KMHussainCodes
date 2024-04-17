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
	mov	rcx, rax
	add	rax, 1
	mul	rcx
	mov	rcx, 2
	div	rcx
	mov	rbx, rax	#rbx=1+2+3+...+(M-1)

	mov	rax, rdi
	mov	rcx, rax
	add	rcx, 1
	mul	rcx
	mov	rcx, 2
	div	rcx		#rax=1+2+3+...+N
	sub	rax, rbx

	PutInt	tell
done:	ret

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Integers: "

	.end

