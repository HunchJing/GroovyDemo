
// def uploadToArtifactoryRaw(String pattern, String target, boolean flat = false, boolean failNoOp = true, Map<String,String> additionalHeaders = [:]) {
//         //String pattern=folder/manifest.xml/changelog.txt
//         //String target=target
//         //boolean flat=true
//         initArtifactory()
        
//         script.sh "ls -al ${pattern}/"
//         boolean recursive = isDirectory(pattern)
//         logger.info("recursive is: ${recursive}")
//         List files = recursive ? script.findFiles(glob: pattern) : [new File(pattern)]
//         logger.info("打印ScriptUtils.groovy.....uploadToArtifactoryRaw()...files is: ${files}")

        
        
//         if (files.size() == 0 || (files.size() == 1 && !isFile(files[0].toString()))) {
//             if (failNoOp) {
//                 script.error("uploadToArtifactoryRaw: no files found with pattern: ${pattern}")
//             } else {
//                 return script.newBuildInfo()
//             }
//         }

//         BuildInfo buildInfo = script.newBuildInfo()
//         String moduleId = "qfil:"+ this.env.BUILD_NUMBER.toString()

//         //files的内容是 [firmware_archive/fastboot_android_qnx_all_images_userdebug_20240513_9.tar.gz, firmware_archive/flashware_build_all_images_userdebug_20240513_9.tar.gz, firmware_archive/flat_build_qfil_images_userdebug_20240513_9.tar.gz, firmware_archive/md5sum_fastboot_android_qnx_9.txt, firmware_archive/md5sum_flashware_build_all_9.txt, firmware_archive/md5sum_flat_build_9.txt, firmware_archive/md5sum_secondary_ufs_9.txt, firmware_archive/secondary_ufs_userdebug_20240513_9.tar.gz]
//         // files.each {
//         //     file -> file.name 是什么，file.path是什么，file.length()是什么
//         // }
//         files.each { file ->
//             String stringFilePath = file.toString()
//             String targetPath = target
//             if (stringFilePath.contains("flat_build")) {
//                 targetPath += "flat_build/"
//                 String urlCmd = this.artifactory.url + "/${targetPath}"
//                 logger.info("打印ScriptUtils.groovy.....uploadToArtifactoryRaw()...urlCmd is: ${urlCmd}")
//                 //urlCmd is: https://artifact.swfcn.i.mercedes-benz.com/artifactory/apricot_rse/i3_RSU/RSE_Daily_Build/20240513/deliverables/fastboot_build/

//                 runCurl('upload', urlCmd, 'PUT', file.toString(), additionalHeaders)
//                 //拼一个file的地址，应该是this.artifactory.url + "/${targetPath}" + file.name
//                 //然后再写入new Artifact
//                 String uploadfileUrl = this.artifactory.url + "/${targetPath}" + file.name
//                 // uploadfileUrl is: https://artifact.swfcn.i.mercedes-benz.com/artifactory/apricot_rse/i3_RSU/RSE_Daily_Build/20240513/deliverables/flat_build/flat_build_qfil_images_userdebug_20240513_9.tar.gz
//                 logger.info("[BuildInfo Debug] uploadfileUrl is: ${uploadfileUrl}")
//                 Artifact artifact = new Artifact(file.name, uploadfileUrl, file.length())
//                 buildInfo.appendArtifacts(artifact, moduleId)
//             }
//             if (stringFilePath.contains("fastboot_android_qnx")) {
//                 targetPath += "fastboot_build/"
//                 String urlCmd = this.artifactory.url + "/${targetPath}"
//                 logger.info("打印ScriptUtils.groovy.....uploadToArtifactoryRaw()...urlCmd is: ${urlCmd}")
//                 runCurl('upload', urlCmd, 'PUT', file.toString(), additionalHeaders)
//                 String uploadfileUrl = this.artifactory.url + "/${targetPath}" + file.name
//                 // uploadfileUrl is: https://artifact.swfcn.i.mercedes-benz.com/artifactory/apricot_rse/i3_RSU/RSE_Daily_Build/20240513/deliverables/flat_build/flat_build_qfil_images_userdebug_20240513_9.tar.gz
//                 logger.info("[BuildInfo Debug] uploadfileUrl is: ${uploadfileUrl}")
//                 Artifact artifact = new Artifact(file.name, uploadfileUrl, file.length())
//                 buildInfo.appendArtifacts(artifact, moduleId)
//             }
//             if (stringFilePath.contains("flashware_build_all")) {
//                 targetPath += "flashware_build/"
//                 String urlCmd = this.artifactory.url + "/${targetPath}"
//                 logger.info("打印ScriptUtils.groovy.....uploadToArtifactoryRaw()...urlCmd is: ${urlCmd}")
//                 runCurl('upload', urlCmd, 'PUT', file.toString(), additionalHeaders)
//                 String uploadfileUrl = this.artifactory.url + "/${targetPath}" + file.name
//                 // uploadfileUrl is: https://artifact.swfcn.i.mercedes-benz.com/artifactory/apricot_rse/i3_RSU/RSE_Daily_Build/20240513/deliverables/flat_build/flat_build_qfil_images_userdebug_20240513_9.tar.gz
//                 logger.info("[BuildInfo Debug] uploadfileUrl is: ${uploadfileUrl}")
//                 Artifact artifact = new Artifact(file.name, uploadfileUrl, file.getlength())
//                 buildInfo.appendArtifacts(artifact, moduleId)
//             }
//             if (stringFilePath.contains("secondary_ufs")) {
//                 targetPath += "secondary_ufs/"
//                 String urlCmd = this.artifactory.url + "/${targetPath}"
//                 logger.info("打印ScriptUtils.groovy.....uploadToArtifactoryRaw()...urlCmd is: ${urlCmd}")
//                 runCurl('upload', urlCmd, 'PUT', file.toString(), additionalHeaders)
//                 String uploadfileUrl = this.artifactory.url + "/${targetPath}" + file.name
//                 // uploadfileUrl is: https://artifact.swfcn.i.mercedes-benz.com/artifactory/apricot_rse/i3_RSU/RSE_Daily_Build/20240513/deliverables/flat_build/flat_build_qfil_images_userdebug_20240513_9.tar.gz
//                 logger.info("[BuildInfo Debug] uploadfileUrl is: ${uploadfileUrl}")
//                 Artifact artifact = new Artifact(file.name, uploadfileUrl, file.length())
//                 buildInfo.appendArtifacts(artifact, moduleId)
//             }
//         }
//         logger.info("结束ScriptUtils.groovy.....uploadToArtifactoryRaw()...")
//         return buildInfo
//     }



def test_get_user_name_method(String pattern){
    if (pattern.startsWith('~/')) {
            pattern = System.getProperty('user.home') + pattern.substring(1)
    }
    println "pattern: ${pattern}"
}

test_get_user_name_method("~/test")