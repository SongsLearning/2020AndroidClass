# 2020AndroidClass

## 5. Layout
Linear  
Grid  
Table  
Raelative  
Frame  

## 6. Widget

## 7. Menu, Dialogue

## 8. FILE
raw  
Internal   
external  

## 10. Intent
Explicit

```
val intent = Intent(this, SubActivity::class.java)
startActivity(intent)
```


Implicit
```
val intent = Intent(Intent.ACTION_DIAL)
val TEST_DIAL_NUMBER = Uri.fromParts("tel", "5551212", null)
intent.setData(TEST_DIAL_NUMBER)
startActivity(intent)
```

## 11. Adapter View
list view

## 14. Service
background, forground
