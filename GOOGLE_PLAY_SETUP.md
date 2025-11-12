# Google Play Console Setup Guide

Complete guide to adding your website to Google Play Console for CamLiveBilliard.

## Prerequisites

✅ Website deployed and accessible via HTTPS
✅ Privacy Policy page live
✅ Terms & Conditions page live
✅ All pages tested and working

## Step-by-Step Guide

### 1. Deploy Your Website

First, deploy your website using one of these methods:
- GitHub Pages (free)
- Netlify (free)
- Firebase Hosting (free)
- Your own hosting

See `DEPLOYMENT.md` for detailed instructions.

### 2. Verify Your URLs

Make sure these pages are accessible:

- **Homepage**: `https://yourdomain.com/`
- **Privacy Policy**: `https://yourdomain.com/privacy-policy.html`
- **Terms**: `https://yourdomain.com/terms-conditions.html`
- **Support**: `https://yourdomain.com/support.html`

### 3. Google Play Console - Main Store Listing

1. **Login to Google Play Console**
   - Go to [play.google.com/console](https://play.google.com/console)
   - Select your app (CamLiveBilliard)

2. **Navigate to Store Presence**
   - Click "Store presence" in left sidebar
   - Click "Main store listing"

3. **Add Website URL**
   - Scroll to "Contact details" section
   - In "Website" field, enter: `https://yourdomain.com`
   - Click "Save"

4. **Add Privacy Policy**
   - In "Privacy Policy" field, enter: `https://yourdomain.com/privacy-policy.html`
   - This is REQUIRED by Google Play
   - Click "Save"

### 4. App Content - Privacy Policy

1. **Navigate to App Content**
   - Click "Policy" > "App content" in left sidebar
   - Click "Privacy policy"

2. **Add Privacy Policy URL**
   - Enter: `https://yourdomain.com/privacy-policy.html`
   - Click "Save"

### 5. Store Listing - App Description

Update your app description to mention the website:

```
CamLiveBilliard - Professional Live Streaming for Billiard Games

Stream your billiard matches to YouTube, Facebook, Twitch, and more with professional features:

✓ Real-time score overlays
✓ HD quality streaming (up to 1080p)
✓ Multi-platform support
✓ Camera controls and filters
✓ Recording capabilities
✓ Remote control via web interface

Perfect for tournament organizers, pool halls, content creators, and players.

Visit our website: https://yourdomain.com
Support: https://yourdomain.com/support.html
```

### 6. Add Screenshots

Recommended screenshots to add:
1. Main streaming interface
2. Score overlay in action
3. Stream settings screen
4. Platform selection screen
5. Live streaming with overlay

### 7. Feature Graphic

Create a feature graphic (1024 x 500 px) showing:
- App logo
- Key features
- Professional billiard imagery
- "Stream Your Game" tagline

### 8. App Icon

Ensure your app icon:
- Is 512 x 512 px
- Follows Material Design guidelines
- Represents billiards/streaming
- Is clear and recognizable

### 9. Data Safety Section

1. **Navigate to Data Safety**
   - Click "App content" > "Data safety"

2. **Data Collection**
   - Select what data you collect:
     - ✓ Location (if using)
     - ✓ Personal info (email, name)
     - ✓ Photos and videos (for streaming)
     - ✓ Audio files (for streaming)
     - ✓ Device or other IDs

3. **Data Usage**
   - Explain how data is used:
     - App functionality
     - Analytics
     - Account management

4. **Data Sharing**
   - Indicate if data is shared with third parties
   - List streaming platforms (YouTube, Facebook, etc.)

5. **Security Practices**
   - ✓ Data is encrypted in transit
   - ✓ Users can request data deletion
   - ✓ Committed to Google Play Families Policy

### 10. Content Rating

1. **Navigate to Content Rating**
   - Click "App content" > "Content rating"

2. **Complete Questionnaire**
   - Select app category: "Utility, Productivity, Communication, or Other"
   - Answer questions honestly
   - Submit for rating

### 11. Target Audience

1. **Navigate to Target Audience**
   - Click "App content" > "Target audience and content"

2. **Select Age Groups**
   - Recommended: 13+ or 18+ (depending on your content policy)
   - Explain: "App is for streaming billiard games"

### 12. Ads Declaration

1. **Navigate to Ads**
   - Click "App content" > "Ads"

2. **Declare Ad Status**
   - Select "No" if you don't show ads
   - Select "Yes" if you plan to show ads
   - Provide ad network details if applicable

### 13. App Access

1. **Navigate to App Access**
   - Click "App content" > "App access"

2. **Provide Test Account (if needed)**
   - If your app requires login, provide test credentials
   - Example:
     - Username: test@camlivebilliard.com
     - Password: TestPass123

### 14. News Apps Declaration

- Select "No" (unless you're a news app)

### 15. COVID-19 Contact Tracing

- Select "No" (unless applicable)

### 16. Data Deletion Instructions

Add to your Privacy Policy and inform Google:

"Users can delete their data by:
1. Opening the app
2. Going to Settings
3. Selecting 'Account Management'
4. Tapping 'Delete Account'

Or by emailing: privacy@camlivebilliard.com"

## Required URLs Summary

Add these URLs to Google Play Console:

| Field | URL |
|-------|-----|
| Website | `https://yourdomain.com` |
| Privacy Policy | `https://yourdomain.com/privacy-policy.html` |
| Terms of Service | `https://yourdomain.com/terms-conditions.html` |
| Support/Help | `https://yourdomain.com/support.html` |

## Common Issues & Solutions

### Issue: Privacy Policy URL Not Accepted

**Solution:**
- Ensure URL uses HTTPS (not HTTP)
- Verify page loads without errors
- Check that content is visible (not behind login)
- URL must be publicly accessible

### Issue: Website Not Loading

**Solution:**
- Wait 24-48 hours for DNS propagation
- Clear browser cache
- Test in incognito mode
- Verify SSL certificate is active

### Issue: Content Policy Violations

**Solution:**
- Review Google Play policies
- Ensure privacy policy is comprehensive
- Add all required disclosures
- Update data safety section accurately

## Pre-Submission Checklist

Before submitting your app, verify:

- [ ] Website is live and accessible
- [ ] Privacy Policy URL added to console
- [ ] Website URL added to console
- [ ] All legal pages are complete
- [ ] Contact information is correct
- [ ] Data safety section completed
- [ ] Content rating obtained
- [ ] Target audience selected
- [ ] App description mentions website
- [ ] Screenshots uploaded (minimum 2)
- [ ] Feature graphic uploaded
- [ ] App icon uploaded
- [ ] All required declarations completed
- [ ] Test account provided (if needed)
- [ ] Privacy policy mentions data deletion
- [ ] Terms of service are clear

## After Submission

### 1. Monitor Review Status

- Check console daily for updates
- Respond to any requests from Google
- Average review time: 3-7 days

### 2. Handle Rejections

If rejected:
- Read rejection reason carefully
- Fix the specific issues mentioned
- Update website if needed
- Resubmit with explanation

### 3. Post-Launch

After approval:
- Monitor user reviews
- Update website with Play Store link
- Respond to user feedback
- Keep legal pages updated

## Maintenance

### Regular Updates

Update these regularly:
- Privacy policy (when you change data practices)
- Terms of service (when you add features)
- Support page (add new FAQs)
- App description (highlight new features)

### Annual Review

Once per year:
- Review all legal documents
- Update "Last Updated" dates
- Verify all links work
- Check for policy changes

## Support Resources

- **Google Play Console Help**: [support.google.com/googleplay/android-developer](https://support.google.com/googleplay/android-developer)
- **Policy Center**: [play.google.com/about/developer-content-policy](https://play.google.com/about/developer-content-policy)
- **Developer Support**: Contact via Play Console

## Contact

For help with your website or Google Play setup:
- Email: support@camlivebilliard.com
- Website: https://yourdomain.com/support.html

## Success Tips

1. **Be Transparent**: Clearly explain what data you collect and why
2. **Be Comprehensive**: Include all required information in legal pages
3. **Be Responsive**: Respond quickly to Google's requests
4. **Be Accurate**: Ensure all information matches your actual app behavior
5. **Be Professional**: Use proper grammar and formatting

## Timeline

Typical timeline for app submission:

- Day 0: Deploy website
- Day 1: Add URLs to Play Console
- Day 2: Complete all declarations
- Day 3: Submit app for review
- Day 3-10: Google review process
- Day 10+: App goes live (if approved)

## Final Notes

- Keep your website online at all times (Google may check periodically)
- Update privacy policy before adding new features that collect data
- Respond to user reviews mentioning privacy or terms
- Keep backup of all legal documents
- Document any changes you make

Good luck with your app submission! 🎱🎥
