.assembly Hello {}
.assembly extern System.Console {} //this assembly belongs Microsoft.NETCore.App framework

.method public static void Run()
{
	.entrypoint

	ldstr	"Goodbye."
	ldstr	"Hello World!"
	call	void [System.Console]System.Console::WriteLine(string)
	call	void [System.Console]System.Console::WriteLine(string)
	ret
}

