
import java.util.regex.Pattern
import java.util.regex.Matcher
import java.text.SimpleDateFormat
import java.util.Calendar

// def shWithStdout(cmd) {
//     def process = cmd.execute()
//     process.waitFor()
//     println "exit code: ${process.exitValue()}"
//     return process.in.text.trim()
// }


// def d2dBootList = """
// "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240324/deliverables/swup/dev/STAR3.0/20240324_300_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
// "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
// "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_303_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar"
// """
// def bootPath = d2dBootList.split(",")[-2].trim()
// def pattern = Pattern.compile('"path": "(.*?)"')
// def matcher = pattern.matcher(bootPath)

// while (matcher.find()) {
//     println "matcher.group(1): ${matcher.group(1)}"
// }


// String getLastAlwaysOnBoot(String jfrogSubRepo, List pathList) {
//         def bootAlwaysOnSpec = "userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar"
//         // def d2dBootList = shWithStdout("jf rt search ${jfrogSubRepo}/ --sort-by=created | grep ${bootAlwaysOnSpec}")
        
//         def pathList = [
//             "apricot_rse/i3_RSU/RSE_Daily_Build/20240324/deliverables/swup/dev/STAR3.0/20240324_300_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
//             "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
//             "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_303_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar"
//         ]
//         def bootPath = d2dBootList.split(",")[-2].trim()
//         println "bootPath: ${bootPath}"
//         def pattern = Pattern.compile('"path": "(.*?)"')
//         Matcher matcher = pattern.matcher(bootPath)
//         if (matcher.find()) {
//             return matcher.group(1)
//         } else {
//             return "Cannot find last boot Always on"
//         }
//     }
// def jfrogSubRepo = "apricot_rse/i3_RSU/RSE_Daily_Build"

// getLastAlwaysOnBoot(jfrogSubRepo)

String getLastAlwaysOnBootBuildNumber(String path_url) {
        // def path = getLastAlwaysOnBoot(jfrogSubRepo)
       
        // 20240325_ 是一个日期，将下面的正则更改为日期，而不是具体的值
        def pattern = ~/(\d{8}_)(\d+)(_userdebug)/
        def matcher = path_url =~ pattern
        if (matcher.find()) {
            return matcher.group(2)
        }else {
            println "Cannot find build number"
        }
}

String extractDataFromUrl(String path_url){
        def pattern = ~/\d{8}/
        def matcher = path_url =~ pattern
        if (matcher.find()) {
            return  matcher.group()
        } else {
            return path_url.split("/")[-3].trim()
        }
    }

def path = "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup_delta/dev/STAR3.0/20240325_303_userdebug/BOOT_TO_RELEASE/"
// def number = getLastAlwaysOnBootBuildNumber(path)
def date = extractDataFromUrl(path)
// println date

// targetDate 的格式是 20240325，返回的格式是 20240324
String getPreviousDate(String currentDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd")
    Calendar calendar = Calendar.getInstance()
    calendar.setTime(dateFormat.parse(currentDate))
    calendar.add(Calendar.DAY_OF_MONTH, -1)
    return dateFormat.format(calendar.getTime())
}
// def targetDate = "20230301"
// def dayBefore = getPreviousDate(targetDate)
// println dayBefore

def getPathList(String dayBeforePackagePaths){
    def pattern = Pattern.compile(/"path": "(.*?)"/)
    Matcher matcher = pattern.matcher(dayBeforePackagePaths)
    def pathList = []

    while (matcher.find()) {
        def path = matcher.group(1)
        pathList.add(path)
    }
    println "pathList: ${pathList}"
    return pathList
}

def getPreviousPackageUrlByDate(String currentDate) {
    def previousDate = getPreviousDate(currentDate)
    println "previousDate: ${previousDate}"
    
    // def dayBeforePackagePaths = """
    // """
    // def dayBeforePackagePaths = """
    // "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    // """
    // def dayBeforePackagePaths = """
    // "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    // "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_303_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    // """
    def dayBeforePackagePaths = """
    "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_303_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    "path": "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_304_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar",
    """
    def pathList = getPathList(dayBeforePackagePaths)
    //  判断pathList是否为空，如果为空，返回“The always boot on package was not generated the day before.”
    // 如果不为空，判断pathList的长度，为1 返回 “have 1”
    // 如果长度大于1，返回 “have 2”
    if (pathList.isEmpty()) {
        println "The always boot on package was not generated the day before."
        return null
    } else if (pathList.size() == 1) {
        println "current path is: ${pathList[0]}"
        return pathList[0]
    } else {
        // 遍历pathList，获取每个path的build number，返回build number最大的path
        def maxBuildNumberPath = pathList.max { path ->
            def matcher = path =~ /(\d{8}_)(\d+)(_userdebug)/
            matcher ? matcher[0][2].toInteger() : 0
        }
        println "maxBuildNumberPath: ${maxBuildNumberPath}"
        return maxBuildNumberPath   
    }
    

    // 想遍历 dayBeforePackageList，构造一个字典，内部为buildnumber:url
    // 例如：[{301: "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_301_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar"},
    // {303: "apricot_rse/i3_RSU/RSE_Daily_Build/20240325/deliverables/swup/dev/STAR3.0/20240325_303_userdebug/BOOT_ALWAYS_ON/logical-blocks-i3-BOOT-STAR30_unencrypted.tar"}]

}


def currentDate = "20240326"
getPreviousPackageUrlByDate(currentDate)

