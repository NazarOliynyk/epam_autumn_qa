//package ua.com.epam.utils.urlBuilder;
//
//import org.apache.http.client.utils.URIBuilder;
//
//import java.net.URISyntaxException;
//
//import static ua.com.epam.utils.JsonKeys.*;
////java.lang.Object
////        org.springframework.web.util.UriComponentsBuilder
////Person person = Person.builder().name("Ivan").surname("Petrenko").mail("emaill").build();
//
//public class UrlBuilder {
//
//    private String orderType;
//    private String page;
//    private String pagination;
//    private String size;
//    private String sortBy;
//    private String query;
//
//
//    static PersonBuilder builder(){
//        return new PersonBuilder();
//    }
//
//    static class PersonBuilder{
//
//        UrlBuilder urlBuilder = new UrlBuilder();
//
//        public PersonBuilder orderType(String orderType){
//            urlBuilder.orderType = "?orderType="+orderType;
//            return this;
//        }
//        public PersonBuilder page(int page){
//            urlBuilder.page = "page="+page;
//            return this;
//        }
//        public PersonBuilder pagination(boolean pagination){
//            urlBuilder.pagination = "pagination="+pagination;
//            return this;
//        }
//
//        public PersonBuilder size(int size){
//            urlBuilder.size = "size="+size;
//            return this;
//        }
//
//
//        public PersonBuilder sortBy(String sortBy){
//            urlBuilder.sortBy = "sortBy="+sortBy;
//            return this;
//        }
//
//        public PersonBuilder query(String query){
//            urlBuilder.query = "query="+query;
//            return this;
//        }
//
//        public UrlBuilder build(){
//            return urlBuilder;
//        }
//    }
//
//    public String getUrl(){
//        return this.orderType+
//                this.page+
//                this.pagination+
//                this.size+
//                this.sortBy+
//                this.query;
//    }
//    @Override
//    public String toString() {
//        return "UrlBuilder{" +
//                "orderType='" + orderType + '\'' +
//                ", page=" + page +
//                ", pagination=" + pagination +
//                ", size=" + size +
//                ", sortBy='" + sortBy + '\'' +
//                ", query='" + query + '\'' +
//                '}';
//    }
//
//    public static void main(String[] args) {
//        String s = UrlBuilder.builder().orderType("asc").page(5).build().getUrl();
//       // System.out.println(s);
//
////        UriComponentsBuilder uriComponentsBuilder = new UriComponentsBuilder();
//
//        URIBuilder builder = new URIBuilder()
////                .setScheme("http")
////                .setHost("apache.org")
////                .setPath("/shindig")
//                .setParameter("orderType", "asc")
//                .setParameter("page", "5")
//                .setParameter("pagination", "true")
//                ;
//        try {
//            builder.build();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//       // System.out.println(builder);
//        System.out.println(new URIBuilder().setParameter("orderType", "asc")
//                .setParameter("page", "1")
//                .setParameter("pagination", "true")
//                .setParameter("size", "5")
//                .setParameter("sortBy", "authorId")
//                .setParameter("query", "foo&bar")
//                .toString());
//    }
//}
