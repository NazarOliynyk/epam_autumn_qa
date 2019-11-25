package ua.com.epam.utils.data.service;

import ua.com.epam.config.DataProp;
import ua.com.epam.entity.author.Author;

import java.util.List;


public class TransferFileToDb {

    private AuthorFileData authorFileData = new AuthorFileData();
    private AuthorDBData authorDBData = new AuthorDBData();

//    private  void print(Author author){
//        System.out.println(String.format(INSERT_AUTHOR, dataProp.dbName(), AUTHOR,
//                author.getAuthorId().intValue(),
//                author.getAuthorName().getFirst(),
//                author.getAuthorName().getSecond(),
//                author.getBirth().getCity(),
//                author.getBirth().getCountry(),
//                author.getBirth().getDate(),
//                author.getAuthorDescription(),
//                author.getNationality()));
//    }

    private void transferData(){
         List<Author> authorList = authorFileData.getDefaultAuthors();
         authorList.forEach(author -> authorDBData.insertAuthor(author));
    }

    public static void main(String[] args) {
        TransferFileToDb transferFileToDb = new TransferFileToDb();
        transferFileToDb.transferData();

    }
}
