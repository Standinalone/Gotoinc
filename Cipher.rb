def decrypt(str, n)
  if str.nil? || str.empty? || n <= 0 then 
    return str
  end
  str = str.downcase

  chars = str.split('')
  chars_temp = str.split('')
  index = 0

  for j in (0..n-1)
    for i in (0..chars.length-1)
      index = i % 2 == 0 ? chars.length / 2 + i / 2 : i / 2
      chars[i] = chars_temp[index]
    end
    chars_temp = chars.clone
  end
  return chars_temp.join('')
end
	
def encrypt(str, n)
  if str.nil? || str.empty? || n <= 0 then 
    return str
  end
  str = str.downcase

  chars = str.split('')
  chars_temp = str.split('')
  index = 0

  for j in (0..n-1)
    for i in (0..chars.length-1)
      index = i % 2 == 0 ? chars.length / 2 + i / 2 : i / 2
      chars[index] = chars_temp[i]
    end
    chars_temp = chars.clone
  end
  return chars_temp.join('')
end
	

encrypted_string1 = encrypt('Abcdefghij', 1)
encrypted_string2 = encrypt("Abcdefghij", 2);
		
puts ("Encrypted once: " + encrypted_string1) #Encrypted once: bdfhjacegi
puts ("Encrypted twice: " + encrypted_string2) #Encrypted twice: dhaeibfjcg
puts		
puts ("Decrypted once: " + decrypt(encrypted_string1, 1)) #Decrypted once: abcdefghij
puts ("Decrypted twice: " + decrypt(encrypted_string2, 2)) #Decrypted twice: abcdefghij
