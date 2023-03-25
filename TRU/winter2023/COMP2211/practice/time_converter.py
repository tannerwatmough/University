total_seconds = float(input('Enter a number of seconds: '))

# Get number of hours
hours = total_seconds // 3600

# Get number of remaining minutes. This is basically seconds divided by 60 twice
minutes = (total_seconds // 60) % 60

# Get number of remaining seconds. Can use remainder because all full 60s are used
seconds = total_seconds % 60

print('Hours:', hours)
print('Minutes', minutes)
print('Seconds', seconds)