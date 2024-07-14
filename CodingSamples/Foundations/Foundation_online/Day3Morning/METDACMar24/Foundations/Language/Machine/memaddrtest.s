	.include "common.i"

	.entry run
run:
	GetInt	askm			#direct addressing (askm)
	mov	rdi, rax
	sub	rdi, 1
	mov	rbx, offset year	#immediate addressing (offset year)
	mov	rax, [rbx+8*rdi]	#indirection (indirect addressing)
	call	Compute
	PutInt	tell
done:	ret

Compute:		
	mov	rcx, rax
	add	rax, 1
	mul	rcx
	shr	rax, 1 	
	ret	

askm:	.string	"Month[1-12]: "
tell:	.string	"Total Amount = "
year:	.quad	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	.end

