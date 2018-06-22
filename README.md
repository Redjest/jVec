# jVec
A Small Fast JAVA Vector Operation Library for Mobile Systems  

jVec is a very small library that may be useful for implementation of vector based systems (signal processing, ML, etc.). 

jVes shines when:
- Used on Android devices, preferbly Android 6.0 (Marshmellow) and up.
- Memory is in shortage and battry is scarce
- Multiple vector operations are needed, but vectors are not too long
- Used by people who are familliar with MATLAB or the Python NumPy library

Use:
Just extend the VectorOperations class by your classes that do vector operations. Vectors in jVec are simply arrays of doubles (sometimes there is also compatability for int arrays).
Commands have the same beavior as in MATLAB and NumPy, the big exaption is that due to the lack of operator overlading in JAVA, the basic arithmetics is done using method calling and not using of operators.
