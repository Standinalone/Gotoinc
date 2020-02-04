
def getMostRecurring(text)
  text = text.downcase  
  arr = text.scan(/[a-zA-Z]+(?:'[a-zA-Z]+)*/)
  hash = {}
  arr.each { |el|
    hash[el] = hash[el].nil? ? 1 : hash[el] + 1
  }
  hash = hash.sort_by { |k, v| -v}
  unique = hash.select { |k, v| v == 1}
  if unique.length < 3 then return [] end
  hash = hash.map{ |k, v| k}.first(3)
end

text = "This is a test String. It's nothing specail, so there's no need to be worried" +
      " about this exact string as it doesn't mean anything and it's created for the" +
      " purpose of demonstrating the function's work whether it returns the array needed" +
      " or not, something like that. It's fascinating!!!"

text2 = "another test"

arr = getMostRecurring(text)
arr.each { |el| print el + ' '} # it's the this

arr = getMostRecurring(text2)
arr.each { |el| print el + ' '} # 
