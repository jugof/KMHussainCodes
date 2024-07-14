	.include "common.i"
	.text

	.entry run
run:	PutMsg	greet1
	PutMsg	greet2
	ret

greet1:	.string	"Hello World!\n\n"
greet2:	.string	"Goodbye.\n"

	.end

