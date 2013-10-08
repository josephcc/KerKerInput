KerKerInput(IMF) Readme
==================================
The KerKer Input Method is an open source Chinese input method framework for Android, 
and likely the first Chinese input methods ever implemented for the Android platform. 
The new version contains improvements on precision of character selection for phonics-based 
input and next-word-prediction using n-gram language model. 

The new KerKerInput is now a input method framework on the existing Android IMF.
Its goal is to provide common used components such as Virtual Keyboard, Physical
KB <=> Virtual KB keycode conversion, candidates mechanism and most importantly
the .cin file support.

I hope this framework could be a starter kit or used as a starting point to
develop your own Android IME in (mostly Traditional) Chinese.

Current Status
==============
KerKerInput is currently working on the Android version 1.5 and after.
Now we provide a few basic input method support and a fun barcode input method,
we also provided some basic demostration modules in the code to show you how
the modules mechanism working.

Documentation is planned. However, due to limited resources, I cannot focus
on this right now. If you would like to see KerKerInput being more actively
developed, please consider a donation. Don't worry, I will still working on this
project right now.

Current WIP
==============
Here are few things I am working on right now:

  - Documentation
  - Common .cin based input module
  - Cleanup dirty codes
  - Make barcode recognition works better
  
You're welcomed to contribute your patch/code by using the github or
email me the patch alone with your contact information for the credit. :)
  
Known Issues
=============

  - Some interaction during switching IME or re-open the IME on another textbox
    is not very smooth.
  - Camera only works on HTC phones for now. Need document for raw camera source
    data for phones from other manufactures. 
  - Camera aspect is incorrect.
  - ... (a lot of bugs here.)

License
=============
 The full code sweep for licensing issues is being working on, but all the framework
 parts are written by me, and will be using MIT license.
   
    Copyright (c) 2008-2009 Chien-An Cho(itsZero), Joseph Chee Chang (josephcc)

    Permission is hereby granted, free of charge, to any person
    obtaining a copy of this software and associated documentation
    files (the "Software"), to deal in the Software without
    restriction, including without limitation the rights to use,
    copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the
    Software is furnished to do so, subject to the following
    conditions:

    The above copyright notice and this permission notice shall be
    included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
    OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
    HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
    WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
    FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
    OTHER DEALINGS IN THE SOFTWARE.
