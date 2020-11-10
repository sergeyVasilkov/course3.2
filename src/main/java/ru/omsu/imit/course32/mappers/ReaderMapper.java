package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.course32.model.Reader;

public interface ReaderMapper {
    @Insert("INSERT INTO reader (card_num,full_name,phone_num,library_address) VALUES ( #{cardNum},#{fullName},#{phone},#{libraryAddress})")
    public Integer insert(Reader reader);

    @Select("SELECT * FROM reader WHERE card_num = #{cardNum}")
    public Reader getReaderByCardNum(@Param("cardNum") int cardNum);


    @Delete("DELETE FROM reader WHERE card_num = #{cardNum}")
    public void deleteByCardNum(@Param("cardNum") int cardNum);

    @Delete("DELETE FROM reader")
    public void deleteAll();
}
