# Shopping Manager Android App

Created by :
Ran Azulay
Nimrod Aharon
Yehuda Ekoz
Inbal Bolshinsky

A simple and efficient Android application for managing shopping lists with user authentication.

## Features

### User Management
- User registration with username, password, and phone number
- Secure login system
- Unique username validation
- Persistent user data storage

### Shopping List Management
- Add products with name and quantity
- Remove products from the list
- View all products in a scrollable list
- Real-time updates when adding/removing products
- Persistent product data storage

### User Interface
- Clean and modern Material Design
- Card-based layouts for better visual organization
- Responsive RecyclerView for product list
- Intuitive navigation between screens
- Clear error messages and success notifications

## Technical Details

### Architecture
- Java-based Android application
- SQLite database for data persistence
- MVC (Model-View-Controller) architecture pattern

### Components

#### Models
- `User.java`: User data model
- `Product.java`: Product data model

#### Database
- `DatabaseHelper.java`: SQLite database management
  - User table for authentication
  - Product table for shopping items
  - Foreign key relationship between users and products

#### Activities
- `MainActivity.java`: Login screen
- `RegisterActivity.java`: User registration
- `ShoppingListActivity.java`: Product management

#### Adapters
- `ProductAdapter.java`: RecyclerView adapter for displaying products

### Data Structure

#### User Table
- username (PRIMARY KEY)
- password
- phone number

#### Product Table
- id (PRIMARY KEY)
- name
- quantity
- user_id (FOREIGN KEY)

## How to Use

1. **Registration**
   - Launch the app
   - Click "New User? Register"
   - Enter username, password, and phone number
   - Click "Register"

2. **Login**
   - Enter registered username and password
   - Click "Login"

3. **Managing Shopping List**
   - Add Product:
     - Enter product name
     - Enter quantity
     - Click "Add Product"
   - Remove Product:
     - Click the trash icon next to the product
   - View Products:
     - All products are displayed in a scrollable list

## Requirements
- Android Studio
- Minimum SDK: API 21 (Android 5.0)
- Target SDK: API 33 (Android 13)

## Dependencies
- AndroidX AppCompat
- AndroidX CardView
- AndroidX RecyclerView
- Material Design Components

## Security Features
- Password protection for user accounts
- SQLite database for secure data storage
- Input validation for all user entries
- Error handling for database operations

## Future Enhancements
- Product categories
- Price tracking
- Shopping history
- Share shopping lists
- Cloud backup
- Dark mode support
- Multi-language support 
