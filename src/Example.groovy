import groovy.xml.MarkupBuilder

class Example {
    static void main(String[] args){
        def markupBuilder = new MarkupBuilder()

        markupBuilder.collect(shelf:'New Arrivals'){
            movie(title:'忠犬八公')
            type('感人')
            type('test')
        }

    }
}
