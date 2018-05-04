# Object-Oriented Programming

This repository hosts the project of the course Object-Oriented Programming.

**Note:** This project is intended to only run using Eclipse IDE.

## Table of Contents

- [Objetives](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#objectives)
- [Structure and Funcionality of the Spreadsheet](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#structure-and-funcionality-of-the-spreadsheet)
  - [Addressing: Cells, Intervals, Ranges](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#addressing-cells-intervals-ranges)
  - [Content: Literals, References, Functions](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#content-literals-references-functions)
  - [Cell Operations](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#cell-operations)
  - [Searches](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#searches)
- [Flexibility and Efficiency Considerations](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#flexibility-and-efficiency-considerations)
- [User Interaction](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#user-interaction)
  - [Cell Addressing](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#cell-addressing)
  - [Main menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#main-menu)
    - [File Manipulation](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#file-manipulation)
    - [Other Options](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#other-options)
  - [Edit Menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#main-menu)
    - [Visualize](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#visualize)
    - [Insert](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#insert)
    - [Copy](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#copy)
    - [Delete](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#delete)
    - [Cut](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#cut)
    - [Paste](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#paste)
    - [View cut buffer](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#view-cut-buffer)
  - [Query Menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#query-menu)
- [Initialization by Text Data File](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#initialization-by-text-data-file) 
- [How To Compile](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#how-to-compile)
- [How To Test](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#how-to-test)

## Objectives

The objective of this project is to develop a spreadsheet, with  The interaction with the application is done using the terminal, where it is displayed all the options that are possible of being performed.

Any help or recommendation is welcome, so feel free to change the code.

## Structure and Funcionality of the Spreadsheet

### Addressing: Cells, Intervals, Ranges

The number of lines and columns of the sheet is fixed. The addresses (positions in the sheet: line and column) begin in 1.

A cell is defined based on it's position in the sheet: _CELL ::= LINE;COLUMN_. <br />
  **Example:** 1;2 (line 1, column 2), or 23;4 (line 23, column 4).
  
An interval (closed) is defined between two cells of the same line or column: _INTERVAL ::= CELL:CELL_. <br />
  **Example:** 1;2:1;20 (line 1, between the columns 2 and 20), or 23;4:57;4 (column 4, between the lines 23 and 57).
  
We use the term "range" to specificy indiscriminately an unique cell or a interval of cells.

### Content: Literals, References, Functions

By omission, the cells are empty (without content). The admissible contents are: literals (integers), references, functions. References are indicated with the symbol "=" followed by the address of the referenced cell. The functions are indicated with the symbol "=", the name of the function and the list (possible empty) of arguments (separated by commas). The following functions are pre-defined:

  1. Binary functions, whose arguments can be references to cells or literal values: **ADD (addition)**, **SUB (subtraction)**, **MUL (multiplication)**, **DIV (division)**. <br />
    **Example:** ADD (2;3,1), SUB (6;2,22;1), MUL (1,2), DIV (1,5;2).
   
   2. Functions applied to an interval of cells: **AVG (average with integer division)**, **PRD (piatorio)**. <br />
    **Example:** AVG (1;2:1;19), PRD (2;33:5;33).
    
It is considered that there are no circular dependencies (direct or indirect), between functions and cells referenced by their arguments. The value to show for invalid references or functions with invalid arguments (reference empty cells), is _#VALUE_.

### Operations On Cells

It is possible to insert, delete and show contents. It is also possible to copy content between cells.

### Searches

It is possible to search the contents of the cells under different aspects: (i) values resulting from evaluation; (ii) names of functions.

## Flexibility and Efficiency Considerations

It should be possible to extend or change functionalities with minimal impact in the produced code: in particular, it should be simples to define new functions and new searches over the cells. The objective is to increase the flexibility of the application relatively to the support of new functions.

It should be possible to represent the structure of a spreadsheet using different approaches without impacting the remaning code of the application. The objective of this requisite is to allow the optimization of the occupied memory space to save the content of a spreadsheet. For example, in the case of spreadsheets of small dimensions you can have a structure that saves all cells regardeless of them being empty or not. This representation is inefficient for situations of spreadsheets of large dimensions and in which there are a great number of empty cells. The solution to develop does not need to materialize all situations (it just needs to materialize the first case) but should be sufficiently flexible to allow new representations.

A function depends of cells whose content can be changed at any moment. As a way to reduce the cost of execution of the application everytime a cell is changed, the number of times that which formula is calculated should be minimized. This requisit should only be considered after everything else is implemented. 

## User Interaction

Described below is the maximum functionality of the interface with the user. In general, the commands ask all the information before validating them (except where indicated). All the menus have the option _"Sair"_ (closes the menu).

The operations of reading and writing of data related with the interaction with the user must be performed through the objects _pt.utl.ist.po.ui.Form_ and _pt.utl.ist.po.ui.Display_, using the messages described (all the messages are produced through the calls to methods). A complete list of available classes can be obtained in the libraries pouilib and calc (support material). The interaction with the user, through operations of reading  or writing, should only be performed in the code related with the interface with the user (and never in the core of the application). It should not be defined any new messages.

The exceptions used in the interaction, except if indicated, are subclasses of _pt.utl.ist.po.ui.InvalidOperation_, are thrown by the commands and treated by _pt.utl.ist.po.ui.Menu_. Note that, besides the exceptions described, it is possible to define others. The new exceptions should not replace the ones given in the cases described in here.

### Cell Addressing

For the request of a range, it is used the message _calc.textui.edit.Message.addressRequest()_. The exception _calc.
textui.edit.InvalidCellRange_ is thrown if the addresses given are invalid.

### Main Menu

The actions of the menu, listed in _calc.textui.main.MenuEntry_, allow the manipulation of files, editing cells, do searches. The methods for the messages of dialog are defined in _calc.textui.main.Message_. 

Initially, the application has no sheet. In this situation, only the options **Criar (create)** and **Abrir (open)** are shown, because the remaining functions require a sheet. The irrelevant options should be omitted in this situation.  

#### File Manipulation

The state of the application can be saved in files, for a posterior recovery (serialization Java: _java.io.Serializable_). In the manipulation of files, the associated exceptions should be treated. The funcionality of each operation is the following:

  **Criar (create) -** Allows to create an empty sheet: the dimensions of the new sheet are required, using the messages _linesRequest()_ and _columnsRequest()_. This sheet is not associated to any file (it is anonymous).
  
  **Abrir (open) -** Loads a new sheet from a previously saved file. The name of the file (_openFile()_) is required: case it does not exist, the message _fileNotFound()_ is shown.
  
  **Guardar (save) -** Saves the sheet in the file associated. If the sheet is anonymous, it is asked for the name of the file that we want to give to it. This interaction is performed through the method _newSaveAs()_. No action is performed if there are no changes since the last save.
  
  **Guardar como... -** This options allows to associate a (new) file to the sheet, saving in that file the state of the sheet. This interaction uses the method _saveAs()_. It is ignored the actual association to a file even if there are changes.

#### Other Options

Besides the operations of manipulation of the files and the basic options of visualization, there are still in the main menu the options of **Menu de Edição (edit menu)** and **Menu de Consultas (search menu)**. This options are only available when a valid active sheet exists.

### Edit Menu

The edit menu allows to view and change the content of the cells of the active sheet. The complete list is the following: **Visualizar (visualize)**, **Inserir (insert)**, **Apagar (delete)**, **Copiar (copy)**, **Cortar (cut)**, **Colar (paste)** and **Visualizar _cut buffer_ (view cut buffer)**. The below sections describe these options.

The options of this menu are defined in the class _calc.textui.edit.MenuEntry_. All methods corresponding to the dialog messages for the actions of the menu are defined in the class _calc.textui.edit.Message_.

#### Visualize

Allows to visualize the intended range, according with the indications of the tables. The first table describes the presentation of a cell for different situations. The first line is for empty cells, the second for cells with a literal and the third for cell that refer formulas or references. The second table describes the presentation of the two types of intervals.

If the content is not a literal, it should be presented it's value and expression (references or formulas). It should not be presented any content for cells that are empty (first example of the below table).

| **Cell: Contents**  |     
| ------------- |           
| _line;column &#124;_ |           
| _line;column &#124; literal_  |           
| _line;column &#124; value=expression_  |

| **Vertical Interval** | **Horizontal Interval** |
| ------------- | ------------- |
| _line1;column &#124; content_  | _line;column1 &#124; content_ |
| _line2;column &#124; content_  | _line;column1 &#124; content_ |
| _line3;column &#124; content_  | _line;column1 &#124; content_ |

#### Insert

It is specified the range. It is specified the content to insert, through the message _contentsRequest()_. The content is inserted in all the cells of the range. For simplicity, names of non-existent functions are not inserted. 

#### Copy

It is specified the range whose content should be copied to the cut buffer. The contents are copied independently of the sheet (i.e., changes to the originals are not propagated to the cut buffer).

#### Delete

It is specified the range whose content should be deleted.

#### Cut

This action corresponds to do a **Copy** and a **Delete** in sequence.

#### Paste

Inserts the content from the cut buffer in the specified range. If the cut buffer is empty no action is performed.

If the range is a single cell, all the content from the cut buffer should be inserted from the specified cell until it is reached the limit of the spreadsheet. Otherwise, if the dimension of the cut buffer is different from the one from the destination range, no value is inserted.

#### View cut buffer

Allows to visualize the content of the cut buffer. The format of the presentation is the one described in **Visualize** (the first cell of the cut buffer always starts in 1;1).

### Search Menu

Allows to do searches over the cells of the active sheet, producing lists of cells. The resulting cells are presented by the order in which they appear in the table in the section **Visualize**. The entries of the menu are defined in _calc.textui.search.MenuEntry_. The messages are defined in _calc.textui.search.Message_.

| **Entry of the menu**  | **Action** |     
| ------------- | ------------- |          
| Search Value | Asks for the value to search (message _searchValue()_) and presents the results. |          
| Search Function  | Asks for the name of the function to search (message _searchFunction()_) and presents the results. |

The term of the search should be compared with the value evaluated in each cell. This way, considering the initial expressions of the cells indicated below, a search for the value _5_ would find the cells _1;3_ and _2;1_:
  _1;1 &#124; 4_
  _1;2 &#124; 1_
  _1;3 &#124; 5_
  _2;1 &#124; 5=ADD(1;1,1;2)_
  _2;2 &#124;_
  _2;3 &#124;_
  
Everytime a search is performed and no entity can satisfy the conditions associated with the request, nothing should be presented.
  
## Initialization by Text Data File

By omission, when the application starts, there is no active sheet. Besides the options described in **File Manipulation**, it is possible to initialize the application using a text file specified by the property Java **import**. The textual data are only a comfortable way of initialization and are never produced by the application (not even to save the state for future exectutions). When the property is specified, it is created an anonymous active sheet that represents the content of the indicated file.

In the processing of data, it is assumed that there are no badly formed entries (cells not referenced are empty). It is suggested the use of the method _String.split_, to divide a chain of characters in fields.

The first two lines define the number of lines and columns of the spreadsheet. The remaining lines always contain the format _line;column|content_.

In the following example, the content of the initial file (_test.import_), corresponds to the sheet below.

**_test.import_**
lines=4
columns=3
3;3|=ADD(3;1,3;2)
4;1|
1;1|5                           
1;2|49
2;1|25
2;2|43
2;3|=ADD(2;2,5)
3;1|10
3;2|=1;1
1;3|=ADD(2,5)
4;3|=AVG(1;3:3;3)
4;2|

|               | **1**         | **2**         | **3**         | 
| ------------- | ------------- | ------------- | ------------- |
| **1**         | 5             | 49            | =ADD(2,5)     |     
| **2**         | 25            | 43            | =ADD(2;2,5)   |        
| **3**         | 10            | =1;1          | =ADD(3;1,3;2) |
| **4**         |               |               | =AVG(1;3:3;3) |

## How To Compile

Use Eclipse IDE. Run the project as a Java application. It will compile and you can use the Eclipse console to perform all the actions described in this project.

## How To Test

Go to the folder /bin/, open a terminal and run the commands **sh runtests.sh** and **sh runtests-ef.sh**, to run the automatic tests.

The message **Done.** will appear after each test, if the tests execute correctly.
