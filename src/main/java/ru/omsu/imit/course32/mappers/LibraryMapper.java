package ru.omsu.imit.course32.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.course32.model.Library;

public interface LibraryMapper {

    @Insert("INSERT INTO library (address) VALUES ( #{address})")
    public Integer insert(Library library);

    @Select("SELECT address FROM library WHERE address = #{address}")
    @Results({
            @Result(property = "address", column = "address")})
    public Library getLibraryByAddress(@Param("address") String address);


    @Delete("DELETE FROM library WHERE library.address = #{address}")
    public void deleteByAddress(@Param("address") String address);

    @Delete("DELETE FROM library")
    public void deleteAll();
}
