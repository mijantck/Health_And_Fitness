
package com.mrsoftit.homefit.WalkandStep;

import android.content.pm.PackageManager;

import com.mrsoftit.homefit.WalkandStep.services.AbstractStepDetectorService;
import com.mrsoftit.homefit.WalkandStep.services.AccelerometerStepDetectorService;
import com.mrsoftit.homefit.WalkandStep.services.HardwareStepDetectorService;
import com.mrsoftit.homefit.WalkandStep.utils.AndroidVersionHelper;




public class Factory {



    public static Class<? extends AbstractStepDetectorService> getStepDetectorServiceClass(PackageManager pm){
        if(pm != null && AndroidVersionHelper.supportsStepDetector(pm)) {
            return HardwareStepDetectorService.class;
        }else{
            return AccelerometerStepDetectorService.class;
        }
    }
}
