import React from 'react';
import BookItem from '../components/book-item'

const BookPage = ({ items, onAddOne, onRemoveOne }) => {
  return (
    <ul className="itemPage-items">
      {items.map((item) => (
        <li key={item.id} className="book-page-item">
          --{item.quantity}--
          <BookItem book={item}>
            <button
              className="remove-from-basket"
              onClick={() => onRemoveOne(item)}
            >
              &ndash;
            </button>
            {item.quantity}
            <button className="add-to-basket" onClick={() => onAddOne(item)}>+</button>
          </BookItem>
        </li>
      ))}
    </ul>
  );
};

export default BookPage;
