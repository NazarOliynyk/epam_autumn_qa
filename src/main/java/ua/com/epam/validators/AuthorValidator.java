package ua.com.epam.validators;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import ua.com.epam.entity.Response;
import ua.com.epam.entity.author.Author;

import java.util.ArrayList;
import java.util.List;



public class AuthorValidator extends AbstractValidator{

    public void getAuthor(Author author) {
        long randomAuthorId = author.getAuthorId();

        Response response = authorService.getAuthor(randomAuthorId);
        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);
        actAuthor = g.fromJson(response.getBody(), Author.class);
        Assert.assertEquals(
                actAuthor,
                author,
                "Actual author's id is not equal to expected. ");
    }


    public void postAuthor(Author author) {

        // saving a randomAuthor-
        Response responseOnCreate = authorService.postAuthor(author);
        // 201 - Created
        Assert.assertEquals(responseOnCreate.getStatusCode(), 201);

        actAuthor = g.fromJson(responseOnCreate.getBody(), Author.class);
        Assert.assertEquals(
                actAuthor,
                author,
                "Actual author is not equal to random.  ");

        //trying to save the same author
        Response responseSameAuthor = authorService.postAuthor(author);
        // 409 - Conflict creating an author with the same id-
        Assert.assertEquals(responseSameAuthor.getStatusCode(), 409);

        // changing authorId and saving-
        author.setAuthorId((long) 5000);
        Response responseChangedId = authorService.postAuthor(author);
        // 201 - Created
        Assert.assertEquals(responseChangedId.getStatusCode(), 201);
        actAuthor = g.fromJson(responseChangedId.getBody(), Author.class);
        Assert.assertEquals(
                actAuthor,
                author,
                "Actual author is not equal to random after changing authorId.  ");
    }


    public void updateAuthor(Author author) {

        Response response = authorService.updateAuthor(
                author,
                3000,
                "Ivan",
                "Ivanov");
        // 200 - OK
        Assert.assertEquals(response.getStatusCode(), 200);

        // compare fields after update-
        actAuthor = g.fromJson(response.getBody(), Author.class);


        softAssert.assertEquals(actAuthor.getAuthorId().intValue(),
                3000);
        softAssert.assertEquals(actAuthor.getAuthorName().getFirst(),
                "Ivan");
        softAssert.assertEquals(actAuthor.getAuthorName().getSecond(),
                "Ivanov");
        softAssert.assertAll();
    }


    public void deleteAuthor(Author author) {

        long authorId = author.getAuthorId();

        // check if the randomAuthor is present in the DB-
        Response responseBeforeDelete =
                authorService.getAuthor(authorId);
        // 200 - OK
        Assert.assertEquals(responseBeforeDelete.getStatusCode(), 200);

        // deleting the random author-
        Response responseOnDeleteAction =
                authorService.deleteAuthor(authorId);
        // 204 - no content
        Assert.assertEquals(responseOnDeleteAction.getStatusCode(), 204);

        // ascertain that the randomAuthor is not present in the DB-
        Response responseAfterDelete =
                authorService.getAuthor(authorId);
        // 404 - not found
        Assert.assertEquals(responseAfterDelete.getStatusCode(), 404);
    }


    public void getAuthorByInitials(String oneCred, String twoCred) {

        // there are 2 authors with initials containing "Fis"
        Response responseOneCred = authorService.getAuthorListByInitials(oneCred);
        Assert.assertEquals(responseOneCred.getStatusCode(), 200);
        List<Author> list1 = g.fromJson(responseOneCred.getBody(), type);
        Assert.assertEquals(list1.size(), 2);

        // there is only one author with initials containing both "Ber" and "Fis"
        Response responseTwoCred = authorService.getAuthorListByInitials(twoCred);
        Assert.assertEquals(responseTwoCred.getStatusCode(), 200);
        List<Author> list2 = g.fromJson(responseTwoCred.getBody(), type);
        Assert.assertEquals(list2.size(), 1);
    }

    public void getDifferentAuthorsWithOptions(String orderType,
                                               int page,
                                               boolean pagination,
                                               int size,
                                               String sortBy) {

        Response response =
                authorService.getAuthorListByParams(
                        orderType,
                        page,
                        pagination,
                        size,
                        sortBy);
        List<Author> authorList = g.fromJson(response.getBody(), type);
//
        //200 -ok
        Assert.assertEquals(response.getStatusCode(), 200);
        List<Integer> idList = new ArrayList<>();
        authorList.forEach(author -> idList.add(author.getAuthorId().intValue()));

        softAssert.assertEquals(size, 10);
        softAssert.assertTrue(Ordering.natural().reverse().isOrdered(idList));
        softAssert.assertAll();

//        Assert.assertTrue(Ordering.natural().isOrdered(idList));(idList));
    }

}
