package com.maria.library.facade;

import com.maria.library.common.Response;
import com.maria.library.facade.dto.BookDto;

public interface IBookFacade {
    Response<BookDto> addBook(BookDto bookDto);
}
