import React from 'react'

const BookItem = ({ book, children }) => {
  return (
    <div className="book">
      <div className="book-left">
        <div className="book-title">
          {book.name}
        </div>
      </div>
      <div className="book-right">
        <div className='book-price'>
        {book.price}€
        </div>
        {children}
      </div>
    </div>
  )
}

export default BookItem
