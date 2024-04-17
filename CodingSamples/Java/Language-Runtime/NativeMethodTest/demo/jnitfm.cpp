#include "Transformer.h"
#include <iostream>

JNIEXPORT jstring JNICALL Java_Transformer_transform(JNIEnv* env, jclass cls, jstring txt)
{
	jint n = env->GetStringLength(txt);
	jchar* buf = new jchar[n];
	jfieldID idSALT = env->GetStaticFieldID(cls, "SALT", "C");
	jchar salt = env->GetStaticCharField(cls, idSALT);
	jstring result;

	std::cout << "Fast transformation..." << std::endl;
	env->GetStringRegion(txt, 0, n, buf);
	for(jint i = 0; i < n; ++i)
		buf[i] ^= salt;
	result = env->NewString(buf, n);
	delete[] buf;

	return result;
}

