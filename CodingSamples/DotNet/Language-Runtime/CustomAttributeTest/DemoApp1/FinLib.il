
//  .NET IL Disassembler.  Version 8.0.0



// Metadata version: v4.0.30319
.assembly extern System.Runtime
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 8:0:0:0
}
.assembly FinLib
{
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilationRelaxationsAttribute::.ctor(int32) = ( 01 00 08 00 00 00 00 00 ) 
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.RuntimeCompatibilityAttribute::.ctor() = ( 01 00 01 00 54 02 16 57 72 61 70 4E 6F 6E 45 78   // ....T..WrapNonEx
                                                                                                                   63 65 70 74 69 6F 6E 54 68 72 6F 77 73 01 )       // ceptionThrows.

  // --- The following custom attribute is added automatically, do not uncomment -------
  //  .custom instance void [System.Runtime]System.Diagnostics.DebuggableAttribute::.ctor(valuetype [System.Runtime]System.Diagnostics.DebuggableAttribute/DebuggingModes) = ( 01 00 07 01 00 00 00 00 ) 

  .custom instance void [System.Runtime]System.Runtime.Versioning.TargetFrameworkAttribute::.ctor(string) = ( 01 00 18 2E 4E 45 54 43 6F 72 65 41 70 70 2C 56   // ....NETCoreApp,V
                                                                                                              65 72 73 69 6F 6E 3D 76 38 2E 30 01 00 54 0E 14   // ersion=v8.0..T..
                                                                                                              46 72 61 6D 65 77 6F 72 6B 44 69 73 70 6C 61 79   // FrameworkDisplay
                                                                                                              4E 61 6D 65 08 2E 4E 45 54 20 38 2E 30 )          // Name..NET 8.0
  .custom instance void [System.Runtime]System.Reflection.AssemblyCompanyAttribute::.ctor(string) = ( 01 00 06 46 69 6E 4C 69 62 00 00 )                // ...FinLib..
  .custom instance void [System.Runtime]System.Reflection.AssemblyConfigurationAttribute::.ctor(string) = ( 01 00 05 44 65 62 75 67 00 00 )                   // ...Debug..
  .custom instance void [System.Runtime]System.Reflection.AssemblyFileVersionAttribute::.ctor(string) = ( 01 00 07 31 2E 30 2E 30 2E 30 00 00 )             // ...1.0.0.0..
  .custom instance void [System.Runtime]System.Reflection.AssemblyInformationalVersionAttribute::.ctor(string) = ( 01 00 05 31 2E 30 2E 30 00 00 )                   // ...1.0.0..
  .custom instance void [System.Runtime]System.Reflection.AssemblyProductAttribute::.ctor(string) = ( 01 00 06 46 69 6E 4C 69 62 00 00 )                // ...FinLib..
  .custom instance void [System.Runtime]System.Reflection.AssemblyTitleAttribute::.ctor(string) = ( 01 00 06 46 69 6E 4C 69 62 00 00 )                // ...FinLib..
  .hash algorithm 0x00008004
  .ver 1:0:0:0
}
.module FinLib.dll
// MVID: {bbf07980-6ce5-4d50-83fc-a41f488a515d}
.custom instance void [System.Runtime]System.Runtime.CompilerServices.RefSafetyRulesAttribute::.ctor(int32) = ( 01 00 0B 00 00 00 00 00 ) 
.imagebase 0x10000000
.file alignment 0x00000200
.stackreserve 0x00100000
.subsystem 0x0003       // WINDOWS_CUI
.corflags 0x00000001    //  ILONLY
// Image base: 0x0x7fe4708c6000


// =============== CLASS MEMBERS DECLARATION ===================

.class public auto ansi beforefieldinit Finance.CarLoan
       extends [System.Runtime]System.Object
{
  .method public hidebysig instance float64 
          Common(float64 amount,
                 int32 period) cil managed
  {
    // Code size       20 (0x14)
    .maxstack  8
    IL_0000:  ldarg.1
    IL_0001:  ldc.r8     500000
    IL_000a:  blt.s      IL_0010

    IL_000c:  ldc.i4.s   18
    IL_000e:  br.s       IL_0012

    IL_0010:  ldc.i4.s   16
    IL_0012:  conv.r8
    IL_0013:  ret
  } // end of method CarLoan::Common

  .method public hidebysig instance float64 
          Commercial(float64 amount,
                     int32 period) cil managed
  {
    // Code size       19 (0x13)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  ldarg.2
    IL_0003:  call       instance float64 Finance.CarLoan::Common(float64,
                                                                  int32)
    IL_0008:  ldc.r8     4
    IL_0011:  sub
    IL_0012:  ret
  } // end of method CarLoan::Commercial

  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_0006:  nop
    IL_0007:  ret
  } // end of method CarLoan::.ctor

} // end of class Finance.CarLoan

.class public auto ansi beforefieldinit Finance.EducationLoan
       extends [System.Runtime]System.Object
{
  .method public hidebysig instance float64 
          Common(float64 amount,
                 int32 period) cil managed
  {
    .custom instance void Finance.MaxDurationAttribute::.ctor(int32) = ( 01 00 05 00 00 00 00 00 ) 
    // Code size       15 (0xf)
    .maxstack  1
    .locals init (float64 V_0)
    IL_0000:  nop
    IL_0001:  ldc.r8     6
    IL_000a:  stloc.0
    IL_000b:  br.s       IL_000d

    IL_000d:  ldloc.0
    IL_000e:  ret
  } // end of method EducationLoan::Common

  .method public hidebysig instance float64 
          Scholar(float64 amount,
                  int32 period) cil managed
  {
    // Code size       10 (0xa)
    .maxstack  8
    IL_0000:  ldc.r8     4
    IL_0009:  ret
  } // end of method EducationLoan::Scholar

  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_0006:  nop
    IL_0007:  ret
  } // end of method EducationLoan::.ctor

} // end of class Finance.EducationLoan

.class public auto ansi beforefieldinit Finance.HomeLoan
       extends [System.Runtime]System.Object
{
  .method public hidebysig instance float64 
          Common(float64 amount,
                 int32 period) cil managed
  {
    // Code size       33 (0x21)
    .maxstack  8
    IL_0000:  ldarg.1
    IL_0001:  ldc.r8     5000000
    IL_000a:  blt.s      IL_0017

    IL_000c:  ldc.r8     8.5
    IL_0015:  br.s       IL_0020

    IL_0017:  ldc.r8     9
    IL_0020:  ret
  } // end of method HomeLoan::Common

  .method public hidebysig instance float64 
          Woman(float64 amount,
                int32 period) cil managed
  {
    // Code size       19 (0x13)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  ldarg.2
    IL_0003:  call       instance float64 Finance.HomeLoan::Common(float64,
                                                                   int32)
    IL_0008:  ldc.r8     1
    IL_0011:  sub
    IL_0012:  ret
  } // end of method HomeLoan::Woman

  .method public hidebysig instance float64 
          Welfare(float64 amount,
                  int32 period) cil managed
  {
    .custom instance void Finance.MaxDurationAttribute::.ctor(int32) = ( 01 00 0C 00 00 00 00 00 ) 
    // Code size       19 (0x13)
    .maxstack  8
    IL_0000:  ldc.r8     0.5
    IL_0009:  ldarg.0
    IL_000a:  ldarg.1
    IL_000b:  ldarg.2
    IL_000c:  call       instance float64 Finance.HomeLoan::Common(float64,
                                                                   int32)
    IL_0011:  mul
    IL_0012:  ret
  } // end of method HomeLoan::Welfare

  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_0006:  nop
    IL_0007:  ret
  } // end of method HomeLoan::.ctor

} // end of class Finance.HomeLoan

.class public abstract auto ansi sealed beforefieldinit Finance.Loans
       extends [System.Runtime]System.Object
{
  .method public hidebysig static float64 
          GetMonthlyInstallment(float64 loan,
                                int32 duration,
                                float64 rate) cil managed
  {
    // Code size       56 (0x38)
    .maxstack  4
    .locals init (float64 V_0,
             int32 V_1,
             float64 V_2)
    IL_0000:  nop
    IL_0001:  ldarg.2
    IL_0002:  ldc.r8     1200
    IL_000b:  div
    IL_000c:  stloc.0
    IL_000d:  ldc.i4.s   12
    IL_000f:  ldarg.1
    IL_0010:  mul
    IL_0011:  stloc.1
    IL_0012:  ldarg.0
    IL_0013:  ldloc.0
    IL_0014:  mul
    IL_0015:  ldc.r8     1
    IL_001e:  ldc.r8     1
    IL_0027:  ldloc.0
    IL_0028:  add
    IL_0029:  ldloc.1
    IL_002a:  neg
    IL_002b:  conv.r8
    IL_002c:  call       float64 [System.Runtime]System.Math::Pow(float64,
                                                                  float64)
    IL_0031:  sub
    IL_0032:  div
    IL_0033:  stloc.2
    IL_0034:  br.s       IL_0036

    IL_0036:  ldloc.2
    IL_0037:  ret
  } // end of method Loans::GetMonthlyInstallment

} // end of class Finance.Loans

.class public auto ansi beforefieldinit Finance.MaxDurationAttribute
       extends [System.Runtime]System.Attribute
{
  .custom instance void [System.Runtime]System.AttributeUsageAttribute::.ctor(valuetype [System.Runtime]System.AttributeTargets) = ( 01 00 40 00 00 00 00 00 )                         // ..@.....
  .field private int32 '<Limit>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .custom instance void [System.Runtime]System.Diagnostics.DebuggerBrowsableAttribute::.ctor(valuetype [System.Runtime]System.Diagnostics.DebuggerBrowsableState) = ( 01 00 00 00 00 00 00 00 ) 
  .method public hidebysig specialname rtspecialname 
          instance void  .ctor([opt] int32 'value') cil managed
  {
    .param [1] = int32(0x00000005)
    // Code size       15 (0xf)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      int32 Finance.MaxDurationAttribute::'<Limit>k__BackingField'
    IL_0007:  ldarg.0
    IL_0008:  call       instance void [System.Runtime]System.Attribute::.ctor()
    IL_000d:  nop
    IL_000e:  ret
  } // end of method MaxDurationAttribute::.ctor

  .method public hidebysig specialname instance int32 
          get_Limit() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      int32 Finance.MaxDurationAttribute::'<Limit>k__BackingField'
    IL_0006:  ret
  } // end of method MaxDurationAttribute::get_Limit

  .method public hidebysig specialname instance void 
          set_Limit(int32 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      int32 Finance.MaxDurationAttribute::'<Limit>k__BackingField'
    IL_0007:  ret
  } // end of method MaxDurationAttribute::set_Limit

  .property instance callconv(8) int32 Limit()
  {
    .get instance int32 Finance.MaxDurationAttribute::get_Limit()
    .set instance void Finance.MaxDurationAttribute::set_Limit(int32)
  } // end of property MaxDurationAttribute::Limit
} // end of class Finance.MaxDurationAttribute

.class public auto ansi beforefieldinit Finance.PersonalLoan
       extends [System.Runtime]System.Object
{
  .method public hidebysig instance float64 
          Common(float64 amount,
                 int32 period) cil managed
  {
    .custom instance void Finance.MaxDurationAttribute::.ctor(int32) = ( 01 00 05 00 00 00 01 00 54 08 05 4C 69 6D 69 74   // ........T..Limit
                                                                         06 00 00 00 ) 
    // Code size       25 (0x19)
    .maxstack  8
    IL_0000:  ldc.r8     11
    IL_0009:  ldc.r8     0.5
    IL_0012:  ldarg.2
    IL_0013:  ldc.i4.3
    IL_0014:  div
    IL_0015:  conv.r8
    IL_0016:  mul
    IL_0017:  add
    IL_0018:  ret
  } // end of method PersonalLoan::Common

  .method public hidebysig instance float64 
          Employee(float64 amount,
                   int32 period) cil managed
  {
    // Code size       19 (0x13)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  ldarg.2
    IL_0003:  call       instance float64 Finance.PersonalLoan::Common(float64,
                                                                       int32)
    IL_0008:  ldc.r8     5
    IL_0011:  sub
    IL_0012:  ret
  } // end of method PersonalLoan::Employee

  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_0006:  nop
    IL_0007:  ret
  } // end of method PersonalLoan::.ctor

} // end of class Finance.PersonalLoan


// =============================================================

// *********** DISASSEMBLY COMPLETE ***********************
