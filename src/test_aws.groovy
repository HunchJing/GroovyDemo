import groovy.xml.MarkupBuilder
import groovy.json.JsonSlurper

// class Example {
//     static void main(String[] args){
//         def markupBuilder = new MarkupBuilder()

//         markupBuilder.collect(shelf:'New Arrivals'){
//             movie(title:'忠犬八公')
//             type('感人')
//             type('test')
//         }

//     }
// }






public String getValue(String key) {
    def secretManager = "{\"Security_Fix_Counter\":\"30\",\"Upload_Version_Archive\":\"[E001.0,E001.1]\"}"
    // def secretManager = "{Security_Fix_Counter:300,Upload_Version_Archive:[E001.0,E001.1]}"
    println "secretManager: ${secretManager}"
    println "key: ${key}"
    def jsonSlurper = new JsonSlurper()
    def parsed = jsonSlurper.parseText(secretManager)
    // println "parsed class: ${parsed.getClass().getName()}"
    // println "Security_Fix_Counter: ${parsed.Security_Fix_Counter}"
    // println "Upload_Version_Archive: ${parsed.Upload_Version_Archive}"

    upstream_upload_version = "E001.2"
    aws_upload_version_archive = parsed.Upload_Version_Archive
    aws_upload_version_archive_list = aws_upload_version_archive.replaceAll(/[\[\]]/, "").split(",").toList()
    // aws_upload_version_archive = aws_upload_version_archive.replaceAll(/(\w+\.\w+)/, '"$1"')
    println "aws_upload_version_archive: ${aws_upload_version_archive_list}"
    println "aws_upload_version_archive class: ${aws_upload_version_archive_list.getClass()}"
    // aws_upload_version_archive_list = Eval.x(null, aws_upload_version_archive)
    // 怎么把aws_upload_version_archive 从[E001.0,E001.1] 变为[E001.0,E001.1,E001.2]
    aws_upload_version_archive_list << upstream_upload_version
    println "aws_upload_version_archive final: ${aws_upload_version_archive_list.toString()}"
    return aws_upload_version_archive_list.toString()
}

public String getValue1() {
    security_fix_counter_from_aws = "33"
    if (security_fix_counter_from_aws.getClass() == String){
		security_fix_counter_from_aws = security_fix_counter_from_aws.toInteger()
	}
    // value = sh(script: "echo '${secret}' | jq -r .${key}", returnStdout: true).trim()
    return security_fix_counter_from_aws
}

def secrectManager = "{Security_Fix_Counter:21,Upload_Version_Archive:[E888.0,E001.1]}"
// println "secret: ${secrectManager}"
// println "secret class: ${secrectManager.getClass()}"
// def test = getValue("Upload_Version_Archive")
// def test = getValue1()
// println test

//我需要提取结果是Rev_0xDC4C.2005
public String test_extract_file_name() {
    def cpldStoragePath = "/apricot_rse/i3_RSU/RSE_Daily_Build/20231102/release_candidate/E048.0/deliverables/firmware/B-sample/CPLD/Rev_0xDC4C.2005.tar.gz"
    def base_cpld_version_file_name = cpldStoragePath.split('/')[-1].replace('.tar.gz', '')
    return base_cpld_version_file_name
}

def test = test_extract_file_name()
println test
