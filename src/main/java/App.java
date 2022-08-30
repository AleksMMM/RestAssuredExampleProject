import io.restassured.RestAssured;
import io.restassured.response.Response;

public class App {

    public static void main(String[] args) {
        simpleGetRequest();

        System.out.println("********************************");
        System.out.println();

        getRequestQueryParam();

        System.out.println("********************************");
        System.out.println();

        postRequestWithBody();

        System.out.println("********************************");
        System.out.println();

        getHeader();


        System.out.println("********************************");
        System.out.println();

        sendHeader();

        System.out.println("********************************");
        System.out.println();

        getCookie();

        System.out.println("********************************");
        System.out.println();

        sendCookie();

    }

    private static void simpleGetRequest() {

        Response response = RestAssured.get("https://playground.learnqa.ru/api/hello");
        response.peek();
    }

    private static void getRequestQueryParam() {
        Response response = RestAssured
                .given()
                .queryParam("name", "Some Name")
                .get("https://playground.learnqa.ru/api/hello");
        response.peek();
    }

    private static void postRequestWithBody() {

        String body = "{\"param\": \"value\"}";

        Response response = RestAssured
                .given()
                .body(body)
                .post("https://playground.learnqa.ru/api/method_post_only");

        response.peek();
    }

    private static void getHeader() {
        Response response = RestAssured
                .post("https://playground.learnqa.ru/api/hello");

        String header = response.getHeader("Content-Type");

        System.out.println(header);
    }

    private static void sendHeader() {
        Response response = RestAssured
                .given()
                .log()
                .headers()
                .header("Content-Type", "text/html")
                .get("https://playground.learnqa.ru/api/hello");
    }

    private static void getCookie() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_cookie");

        System.out.println("Cookie - " + response.cookies());

        System.out.println("Значение cookie " + response.getCookie("MyCookie"));


    }

    private static void sendCookie() {

        Response response = RestAssured
                .given()
                .queryParam("login", "secret_login")
                .queryParam("password", "secret_pass")
                .get("https://playground.learnqa.ru/api/get_auth_cookie");

        System.out.println("Получение cookie " + response.cookies());
        String cook = response.cookie("auth_cookie");

        Response response2 = RestAssured
                .given()
                .log()
                .cookies()
                .cookie("auth_cookie", cook)
                .get("https://playground.learnqa.ru/api/check_auth_cookie");

        System.out.println(response2.body().asString());
    }
}